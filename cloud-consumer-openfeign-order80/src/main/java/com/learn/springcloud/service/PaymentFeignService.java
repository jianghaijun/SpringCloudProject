package com.learn.springcloud.service;

import com.learn.springcloud.entities.Payment;
import com.learn.springcloud.entities.ResultBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author      : JHJ
 * @Date        : 2021/10/20/21:10
 * @Description : 
 */
@Configuration
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public ResultBase<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/getFeignTimeOut")
    public String getFeignTimeOut();
}
