package com.example.orderservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class OrderController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/orders")
    public Map<String, String> getOrders() {
        return Map.of(
            "message", "Order service handled the request",
            "instancePort", port
        );
    }
}
