package com.learn.springcloud.dao;

import com.learn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int savePayment(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
