package com.learn.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : JHJ
 * @Date : 2021/10/17/12:18
 * @Description :
 */
@RestController
public class ConsumerZkOrderController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @GetMapping("/consumer/zk/payment")
    public String getPaymentInfo() {
        String res = restTemplate.getForObject(PAYMENT_URL + "/zk/payment", String.class);
        return res;
    }
}
