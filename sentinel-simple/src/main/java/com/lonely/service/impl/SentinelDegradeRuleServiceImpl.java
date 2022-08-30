package com.lonely.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lonely.controller.SentinelDegradeController;
import com.lonely.service.SentinelDegradeRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 独孤小标
 * @description
 * @since 2022/8/30 11:08 下午
 */
@Service
@Slf4j
public class SentinelDegradeRuleServiceImpl implements SentinelDegradeRuleService {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 测试degrade
     *
     * @return
     */
    @Override
    @SentinelResource(value = SentinelDegradeController.RESOURCE_NAME, blockHandler = "testDegradeForBlockHandler", fallback = "testDegradeFallBack")
    public String testDegrade() {

        int incrementAndGet = atomicInteger.incrementAndGet();
        if (incrementAndGet % 2 == 0) {
            System.out.println(1 / 0);
        }

        return "hello_world";
    }

    /**
     * 降级方法
     *
     * @param blockException
     * @return
     */
    public String testDegradeForBlockHandler(BlockException blockException) {
        log.info("被降级了...");
        return "被降级了";
    }

    /**
     * 异常处理
     *
     * @param t
     * @return
     */
    public String testDegradeFallBack(Throwable t) {
        log.error("出现异常：{}", t.getMessage());
        return "出现异常了";
    }

}
