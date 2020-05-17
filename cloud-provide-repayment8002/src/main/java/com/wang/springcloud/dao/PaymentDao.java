package com.wang.springcloud.dao;

import com.wang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud2020
 * @description:
 * @author: Wdf
 * @create: 2020-03-25 19:32
 **/
@Mapper
public interface PaymentDao {
    public  int create (Payment payment);
    public  Payment getPaymentById(@Param("id") long id);

}
