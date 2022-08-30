package com.lonely.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.lonely.service.SentinelFlowRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 独孤小标
 * @description 流控相关
 * @since 2022/8/30 9:54 下午
 */
@RestController
@RequestMapping("/flow")
@Slf4j
public class SentinelFlowRuleController {

    @Autowired
    private SentinelFlowRuleService sentinelFlowRuleService;

    @GetMapping("/testQps")
    public String testQps()  {
        return this.sentinelFlowRuleService.testQps();
    }



    @PostConstruct
    private static void initFlowRule() {

        List<FlowRule> flowRules = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("testQps");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(2);
        flowRules.add(flowRule);


        FlowRule flowRule2 = new FlowRule();
        flowRule2.setResource("hello2");
        flowRule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule2.setCount(2);
        flowRules.add(flowRule2);


        FlowRuleManager.loadRules(flowRules);

    }

}
