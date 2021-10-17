package com.learn.springcloud.service.impl;

import com.learn.springcloud.dao.PaymentDao;
import com.learn.springcloud.entities.Payment;
import com.learn.springcloud.entities.ResultBase;
import com.learn.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Value("${server.port}")
    private String port;

    @Override
    public ResultBase savePayment(Payment payment) {
        int resultSize = paymentDao.savePayment(payment);
        if (resultSize > 0) {
            return new ResultBase("200", "添加成功啦！", null);
        } else {
            return new ResultBase("205", "添加失败！", null);
        }
    }

    @Override
    public ResultBase getPaymentById(Long id) {
        Payment dbPayment = paymentDao.getPaymentById(id);
        if (dbPayment != null) {
            return new ResultBase("200", "查询成功！ port=" + port, dbPayment);
        } else {
            return new ResultBase("205", "查询失败！", null);
        }
    }
}
