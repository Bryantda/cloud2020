package com.wang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @program: cloud2020
 * @description:
 * @author: Wdf
 * @create: 2020-03-26 18:56
 **/
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/payment/consul")
    public String payment(){
        return "springcloud with consul"+port+"\t"+ UUID.randomUUID().toString();
    }

}
