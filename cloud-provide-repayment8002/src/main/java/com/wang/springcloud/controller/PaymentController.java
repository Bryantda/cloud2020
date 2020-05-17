package com.wang.springcloud.controller;




import com.wang.springcloud.entities.CommonResult;
import com.wang.springcloud.entities.Payment;
import com.wang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: cloud2020
 * @description:
 * @author: Wdf
 * @create: 2020-03-25 19:53
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
       if (result >0){
           return new CommonResult(200,"插入数据成功"+port,result);
       }else{
           return new CommonResult(200,"插入数据失败"+port,null);
       }
    }


    @GetMapping (value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentByID(@PathVariable("id") long id ){
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("bbb");
        if (payment != null){
            return new CommonResult(200,"查询数据成功"+port,payment);
        }else{
            return new CommonResult(200,"查询数据失败"+port,null);
        }
    }

    //DiscoveryClien 两个
    @Resource
    private DiscoveryClient discoveryClient;
    //import org.springframework.cloud.client.discovery.Discovery


    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element:
                services) {
            System.out.println(element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance:
                instances) {
            System.out.println(serviceInstance.getHost()+"\t"
                    +serviceInstance.getInstanceId()+"\t"
                    +serviceInstance.getPort()+"\t"
                    +serviceInstance.getUri());
        }
        return discoveryClient;
    }
}
