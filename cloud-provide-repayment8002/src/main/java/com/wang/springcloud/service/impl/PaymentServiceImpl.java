package com.wang.springcloud.service.impl;

import com.wang.springcloud.dao.PaymentDao;
import com.wang.springcloud.entities.Payment;
import com.wang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @program: cloud2020
 * @description:
 * @author: Wdf
 * @create: 2020-03-25 19:48
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public  int create (Payment payment){
        return paymentDao.create(payment);
    }
    public  Payment getPaymentById(long id){
        return paymentDao.getPaymentById(id);
    }


}
