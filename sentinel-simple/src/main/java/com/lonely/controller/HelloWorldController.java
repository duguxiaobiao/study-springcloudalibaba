package com.lonely.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2022-08-30 16:57
 * @author: ztkj-hzb
 * @description:
 **/
@RestController
//@RequestMapping("/sentinel")
public class HelloWorldController {


    @RequestMapping("/hello")
    public String hello() {

        String ruleName = "hello";
        flowRule(ruleName, 5);

        for (int i = 0; i <= 10; i++) {
            //entry这里是关键逻辑，它会基于滑动时间窗口来进行限流统计；
            //所以此处才是限流的关键
            try (Entry entry = SphU.entry(ruleName)) {
                System.out.println(("" + (int) entry.getCurNode().successQps()));
            } catch (BlockException ex) {
                // 处理被流控的逻辑
                System.out.println("blocked!");
            }
        }


        return null;
    }


    /**
     * 基于QPS的资源限流
     *
     * @param name  -- 资源名称
     * @param count -- 数量
     */
    public static void flowRule(String name, int count) {
        //限流规则，可以多个flow rule,该规则支持QPS和并发线程数的限流
        //FlowRuleManager.getRules()可以获取到已经设置的限流规则
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //设置资源名称，sentinel限流都是以资源为单位进行
        rule.setResource(name);
        //使用QPS限流
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //QPS达到的数量阈值
        rule.setCount(count);
        rules.add(rule);
        //重新加载限流规则，此处将覆盖原有的限流，所以如果想要不覆盖
        //请使用FlowRuleManager.getRules()获取到的加入到rules中
        FlowRuleManager.loadRules(rules);
    }


}
