package com.learen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : JHJ
 * @Date : 2021/10/24/15:30
 * @Description :
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String info;

    @RequestMapping("/getServerPort")
    public String getServerPort() {
        return info;
    }
}
