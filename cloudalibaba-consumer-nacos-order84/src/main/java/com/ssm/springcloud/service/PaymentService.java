package com.ssm.springcloud.service;

import com.ssm.springcloud.entities.CommonResult;
import com.ssm.springcloud.entities.Payment;
import com.ssm.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/26 16:25
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
