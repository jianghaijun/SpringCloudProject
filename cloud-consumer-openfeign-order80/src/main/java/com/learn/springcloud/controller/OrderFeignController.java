package com.learn.springcloud.controller;

import com.learn.springcloud.entities.Payment;
import com.learn.springcloud.entities.ResultBase;
import com.learn.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : JHJ
 * @Date : 2021/10/20/21:38
 * @Description :
 */
@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/getFeign/{id}")
    public ResultBase<Payment> selectOne(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/feign/timeout")
    public String getFeignTimeOut() {
        return paymentFeignService.getFeignTimeOut();
    }
}
