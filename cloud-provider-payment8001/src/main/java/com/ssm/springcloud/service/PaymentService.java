package com.ssm.springcloud.service;

import com.ssm.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/13 14:55
 */

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
