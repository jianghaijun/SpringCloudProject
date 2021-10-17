package com.learn.springcloud.controller;

import com.learn.springcloud.entities.Payment;
import com.learn.springcloud.entities.ResultBase;
import com.learn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient ciscoveryClient;

    @PostMapping(value = "/payment/savePayment")
    public ResultBase savePayment(@RequestBody(required = false) Payment payment) {
        return paymentService.savePayment(payment);
    }

    @GetMapping(value = "/payment/get/{id}")
    public ResultBase getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/payment/discovery")
    public Object getDiscoveryInfo() {
        List<String> services = ciscoveryClient.getServices();

        List<ServiceInstance> instances = ciscoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance :instances) {
            log.info(instance.getInstanceId()  + "-" + instance.getHost() + ":" + instance.getPort() + "-" + instance.getUri() + "\t");
        }
        return ciscoveryClient;
    }
}
