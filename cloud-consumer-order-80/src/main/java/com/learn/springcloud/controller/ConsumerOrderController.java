package com.learn.springcloud.controller;

import com.learn.springcloud.entities.Payment;
import com.learn.springcloud.entities.ResultBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerOrderController {
    private static final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/savePayment")
    public ResultBase savePayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/savePayment", payment, ResultBase.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public ResultBase getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, ResultBase.class);
    }
}
