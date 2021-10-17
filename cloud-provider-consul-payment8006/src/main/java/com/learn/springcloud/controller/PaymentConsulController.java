package com.learn.springcloud.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : JHJ
 * @Date : 2021/10/17/12:06
 * @Description :
 */
@RestController
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/consul/payment")
    public String paymentConsul() {
        return "spring cloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
