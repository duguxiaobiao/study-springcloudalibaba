package com.lonely.controller;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.lonely.service.SentinelDegradeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 独孤小标
 * @description 验证降级
 * @since 2022/8/30 10:47 下午
 */
@RestController
@RequestMapping("/degrade")
public class SentinelDegradeController {

    public static final String RESOURCE_NAME = "test_degrade";

    @Autowired
    private SentinelDegradeRuleService sentinelDegradeRuleService;

    @GetMapping("/testDegrade")
    public String testDegrade(){
        return this.sentinelDegradeRuleService.testDegrade();
    }

    /**
     * 初始化规则
     */
    @PostConstruct
    private static void initRules(){

        List<DegradeRule> degradeRules = new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource(RESOURCE_NAME);
        //降级策略： 异常数策略
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        //设置异常数
        degradeRule.setCount(2);
        //设置触发熔断的最小请求数
        degradeRule.setMinRequestAmount(2);
        //设置统计时长为60秒
        degradeRule.setStatIntervalMs(60 * 1000);
        //设置熔断时长为10秒
        degradeRule.setTimeWindow(10);

        degradeRules.add(degradeRule);
        DegradeRuleManager.loadRules(degradeRules);

        //以上配置组成的结果就是： 如果请求在1分钟之内最少请求了两次，且发生异常了2次，则会触发熔断，且熔断时间为10秒
        // 10秒后会恢复成半熔断状态，如果后一个请求成功，则恢复成正常状态，如果请求失败，则直接进入熔断状态，不会按照上述规则来

    }

}
