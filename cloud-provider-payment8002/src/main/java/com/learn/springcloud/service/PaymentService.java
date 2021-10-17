package com.learn.springcloud.service;

import com.learn.springcloud.entities.Payment;
import com.learn.springcloud.entities.ResultBase;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public ResultBase savePayment(Payment payment);

    public ResultBase getPaymentById(@Param("id") Long id);
}
