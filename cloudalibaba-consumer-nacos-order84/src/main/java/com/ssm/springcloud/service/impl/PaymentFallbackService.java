package com.ssm.springcloud.service.impl;

import com.ssm.springcloud.entities.CommonResult;
import com.ssm.springcloud.entities.Payment;
import com.ssm.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/26 16:25
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
