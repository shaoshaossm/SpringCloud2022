package com.ssm.springcloud.service;

import com.ssm.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/18 13:53
 */
@Component
@FeignClient(value = "Cloud-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
