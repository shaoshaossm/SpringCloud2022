package com.ssm.springcloud.service.impl;

import com.ssm.springcloud.dao.PaymentDao;
import com.ssm.springcloud.entities.Payment;
import com.ssm.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/13 14:56
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
