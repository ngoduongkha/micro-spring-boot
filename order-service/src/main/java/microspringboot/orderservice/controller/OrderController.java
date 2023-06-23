package microspringboot.orderservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import microspringboot.orderservice.aggregate.order.Order;
import microspringboot.orderservice.dto.ProductDto;
import microspringboot.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private static final String PRODUCT_SERVICE_URL = "http://localhost:10500/api/products";
    private static final String ORDER_SERVICE = "orderService";
    private final OrderService orderService;
    private final RestTemplate restTemplate;

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/products")
    @CircuitBreaker(name = ORDER_SERVICE, fallbackMethod = "findAllWithProductsFallback")
    public List<ProductDto> findAllWithProducts(@RequestParam("category") String category) {
        String url = category == null ? PRODUCT_SERVICE_URL : PRODUCT_SERVICE_URL + "/" + category;
        return restTemplate.getForObject(url, ArrayList.class);
    }

    public List<ProductDto> findAllWithProductsFallback(String category, Throwable throwable) {
        return new ArrayList<>();
    }
}
