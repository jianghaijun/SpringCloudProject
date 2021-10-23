package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author : JHJ
 * @Date : 2021/10/23/12:56
 * @Description :
 */
@SpringBootApplication
@EnableHystrixDashboard
public class OrderHystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixDashboardMain9001.class, args);
    }
}
