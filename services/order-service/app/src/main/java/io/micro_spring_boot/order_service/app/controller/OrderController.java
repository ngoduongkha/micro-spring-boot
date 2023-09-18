package io.micro_spring_boot.order_service.app.controller;

import io.micro_spring_boot.order_service.app.dto.OrderRequest;
import io.micro_spring_boot.order_service.app.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Placing Order");
        return CompletableFuture.supplyAsync(() -> orderService.placeOrder(orderRequest));
    }
}
