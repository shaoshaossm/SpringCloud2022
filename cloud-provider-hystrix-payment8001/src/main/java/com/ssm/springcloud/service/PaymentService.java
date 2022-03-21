package com.ssm.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/19 10:29
 */
@Service
public class PaymentService {
    public String payment_Info_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " PaymentInfo_OK,id" + id + "\t" + "😊";
    }
//    设置自身调用超时时间的峰值，峰值内可以正常运行，超过了需要有兜底的方法处理，作服务降级fallback
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")//3秒钟以内就是正常的业务逻辑

    })
    public String payment_Info_TimeOut(Integer id) {
//        int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(3);;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " PaymentInfo_TimeOut,id" + id + "\t" + "😊 耗时3s";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeOutHandler,id" + id + "\t" + "😊兜底方法 耗时3s";
    }


    //=========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数超过了峰值，熔断器将从关闭转到开启
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),// 时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少跳闸 60%
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)

        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }




}
