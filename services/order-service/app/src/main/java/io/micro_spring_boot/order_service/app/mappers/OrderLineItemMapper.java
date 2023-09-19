package io.micro_spring_boot.order_service.app.mappers;

import io.micro_spring_boot.order_service.app.dto.CreateOrderRequest;
import io.micro_spring_boot.order_service.app.dto.GetProductResponse;
import io.micro_spring_boot.order_service.domain.aggregates.order.OrderLineItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper
public interface OrderLineItemMapper {
    @Mapping(target = "price", source = "productResponse.price")
    @Mapping(target = "skuCode", source = "orderLineItemsDto.skuCode")
    @Mapping(target = "quantity", source = "orderLineItemsDto.quantity")
    @Mapping(target = "productId", source = "productResponse.id")
    @Mapping(target = "orderId", source = "orderId")
    OrderLineItem mapFromDto(CreateOrderRequest.OrderLineItem orderLineItemsDto, UUID orderId, GetProductResponse productResponse);
}
