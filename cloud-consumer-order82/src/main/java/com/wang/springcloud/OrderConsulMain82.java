package com.wang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: cloud2020
 * @description:
 * @author: Wdf
 * @create: 2020-03-26 19:06
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain82 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain82.class,args);
    }
}
