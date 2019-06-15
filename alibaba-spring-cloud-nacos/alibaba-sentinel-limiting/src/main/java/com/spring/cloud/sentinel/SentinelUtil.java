package com.spring.cloud.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public final class SentinelUtil {

    public static String handleException(BlockException ex) {
        System.err.println("错误发生: " + ex.getClass().getCanonicalName());
        return "error";
    }
}

