package com.lonely.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lonely.service.SentinelFlowRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 独孤小标
 * @description
 * @since 2022/8/30 10:14 下午
 */
@Service
@Slf4j
public class SentinelFlowRuleServiceImpl implements SentinelFlowRuleService {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 测试qps
     *
     * @return
     */
    @Override
    @SentinelResource(value = "testQps", blockHandler = "testQpsForBlockHandler", fallback = "testQpsForFallBack")
    public String testQps() {

        int incrementAndGet = atomicInteger.incrementAndGet();

        if (incrementAndGet % 2 == 0) {
            System.out.println(1 / 0);
        }

        return "hello_world";
    }

    /**
     * 流控处理
     *
     * @param blockException
     * @return
     */
    public String testQpsForBlockHandler(BlockException blockException) {
        log.info("被流控：{}", blockException.getRule().getClass().getName());
        return "被流控了";
    }


    /**
     * 异常回调
     *
     * @param t
     * @return
     */
    public String testQpsForFallBack(Throwable t) {
        log.error("异常消息：{}", t.getMessage());
        return "出现异常了";
    }
}
