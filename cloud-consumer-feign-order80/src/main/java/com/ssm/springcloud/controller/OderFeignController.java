package com.ssm.springcloud.controller;

import com.ssm.springcloud.entities.CommonResult;
import com.ssm.springcloud.entities.Payment;
import com.ssm.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/18 14:04
 */
@RestController
public class OderFeignController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        // openfeign-ribbon 客户端默认3s
        return paymentService.paymentFeignTimeout();
    }


}
