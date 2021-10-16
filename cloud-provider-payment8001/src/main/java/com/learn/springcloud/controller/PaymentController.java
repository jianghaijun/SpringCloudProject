package com.learn.springcloud.controller;

import com.learn.springcloud.entities.Payment;
import com.learn.springcloud.entities.ResultBase;
import com.learn.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/savePayment")
    public ResultBase savePayment(@RequestBody(required = false) Payment payment) {
        return paymentService.savePayment(payment);
    }

    @GetMapping(value = "/payment/get/{id}")
    public ResultBase getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }
}
