package com.example.orderclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
public class OrderProxyController {
    private final RestTemplate restTemplate;

    public OrderProxyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/client/orders")
    public Map getOrderFromService() {
        return restTemplate.getForObject("http://order-service/orders", Map.class);
    }
}
