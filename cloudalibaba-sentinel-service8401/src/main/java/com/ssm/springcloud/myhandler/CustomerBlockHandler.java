package com.ssm.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ssm.springcloud.entities.CommonResult;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/26 13:41
 */
public class CustomerBlockHandler {
    /**
     * 兜底方法1
     * @param exception
     * @return
     */
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }

    /**
     * 兜底方法2
     * @param exception
     * @return
     */
    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }
}
