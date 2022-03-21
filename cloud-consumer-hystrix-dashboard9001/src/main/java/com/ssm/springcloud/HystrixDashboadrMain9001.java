package com.ssm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/20 13:21
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboadrMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboadrMain9001.class,args);
    }
}
