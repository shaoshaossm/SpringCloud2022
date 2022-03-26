package com.ssm.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ssm.springcloud.entities.CommonResult;
import com.ssm.springcloud.entities.Payment;
import com.ssm.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/26 13:26
 */
@RestController
public class RateLimitController {
    /**
     * value:资源名
     * blockHandler ： 指定兜底方法
     * @return
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    /**
     * 兜底方法
     * @param exception
     * @return
     */
    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    /**
     * 未指定兜底方法，使用官方默认兜底方法，目前版本报500错误
     * @return
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl()
    {
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }

    /**
     * value:资源名
     * blockHandlerClass：指定兜底的类
     * blockHandler：指定兜底类中的指定方法
     * @return
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,//<-------- 自定义限流处理类
            blockHandler = "handlerException2")//<-----------
    public CommonResult customerBlockHandler()
    {
        return new CommonResult(200,"按客戶自定义",new Payment(2020L,"serial003"));
    }
}