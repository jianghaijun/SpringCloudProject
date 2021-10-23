package com.learn.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author : JHJ
 * @Date : 2021/10/23/11:06
 * @Description :
 */
@Service
public class PaymentHystrixService {

    public String paymentInfoOk(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "paymentInfoOk" + id + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String paymentInfoTimeout(Integer id) {
        int age = 10/0;
//        int time = 3;
//        try {
//            TimeUnit.SECONDS.sleep(time);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "线程池: " + Thread.currentThread().getName() + "paymentInfoOk" + id + "超时"  + "秒O(∩_∩)O哈哈~";
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "系统繁忙o(╥﹏╥)o";
    }
}
