package io.micro_spring_boot.order_service.app.controller;

import io.micro_spring_boot.order_service.app.dto.CreateOrderRequest;
import io.micro_spring_boot.order_service.app.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody @Valid CreateOrderRequest orderRequest) {
        log.info("Placing Order");
        orderService.placeOrder(orderRequest);
    }
}
