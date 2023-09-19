package io.micro_spring_boot.order_service.app.service.impl;

import io.micro_spring_boot.order_service.app.dto.GetProductResponse;
import io.micro_spring_boot.order_service.app.dto.InventoryResponse;
import io.micro_spring_boot.order_service.app.dto.CreateOrderRequest;
import io.micro_spring_boot.order_service.app.events.OrderPlacedEvent;
import io.micro_spring_boot.order_service.app.mappers.OrderLineItemMapper;
import io.micro_spring_boot.order_service.app.service.OrderService;
import io.micro_spring_boot.order_service.domain.aggregates.order.Order;
import io.micro_spring_boot.order_service.domain.aggregates.order.OrderLineItem;
import io.micro_spring_boot.order_service.infra.repositories.OrderLineItemRepository;
import io.micro_spring_boot.order_service.infra.repositories.OrderRepository;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderLineItemMapper orderLineItemMapper = Mappers.getMapper(OrderLineItemMapper.class);
    private final OrderRepository orderRepository;
    private final OrderLineItemRepository orderLineItemRepository;
    private final WebClient.Builder webClientBuilder;
    private final ObservationRegistry observationRegistry;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void placeOrder(CreateOrderRequest orderRequest) {
        var skuCodes = orderRequest.orderLineItems().stream()
            .map(CreateOrderRequest.OrderLineItem::skuCode)
            .toList();

//        Observation inventoryServiceObservation = Observation.createNotStarted("inventory-service-lookup", this.observationRegistry);
//        inventoryServiceObservation.lowCardinalityKeyValue("call", "inventory-service");

//        inventoryServiceObservation.observe(() -> {
        var inventoryResponse = webClientBuilder.build().get()
            .uri("http://localhost:10520/api/inventory",
                uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
            .retrieve()
            .bodyToFlux(InventoryResponse.class)
            .collectList()
            .block();

        var allProductsInStock = Optional.ofNullable(inventoryResponse)
            .orElse(Collections.emptyList())
            .stream()
            .allMatch(InventoryResponse::isInStock);

        if (allProductsInStock) {
            var productResponse = webClientBuilder.build().get()
                .uri("http://localhost:10500/api/products",
                    uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToFlux(GetProductResponse.class)
                .collectList()
                .block();

            Order order = new Order();
            orderRepository.saveAndFlush(order);

            List<OrderLineItem> orderLineItems = orderRequest.orderLineItems()
                .stream().map(e -> orderLineItemMapper.mapFromDto(e, order.getId(), productResponse.stream().filter(p -> p.skuCode().equals(e.skuCode())).findFirst().get()))
                .toList();

            orderLineItemRepository.saveAll(orderLineItems);
//                applicationEventPublisher.publishEvent(new OrderPlacedEvent(this, order.getId()));
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
//        });
    }
}
