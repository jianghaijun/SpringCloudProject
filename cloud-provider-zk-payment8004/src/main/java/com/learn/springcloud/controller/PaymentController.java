package com.learn.springcloud.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : JHJ
 * @Date : 2021/10/17/12:06
 * @Description :
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/zk/payment")
    public String paymentZk() {
        return "spring cloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
