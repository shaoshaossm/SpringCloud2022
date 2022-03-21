package com.ssm.springcloud.service.impl;

import com.ssm.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/20 10:21
 */
@Component
public class PaymentfallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentfallbackService fall back paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentfallbackService fall back paymentInfo_TimeOut";
    }
}
