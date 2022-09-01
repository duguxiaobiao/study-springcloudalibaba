package com.lonely.filters;

import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.support.HttpStatusHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.setResponseStatus;

/**
 * @date: 2022-09-01 16:43
 * @author: ztkj-hzb
 * @description: 自定义gateway过滤器
 **/
@Component
public class CheckAuthGatewayFilterFactory extends AbstractGatewayFilterFactory<CheckAuthGatewayFilterFactory.Config> {


    public CheckAuthGatewayFilterFactory() {
        super(CheckAuthGatewayFilterFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

    @Override
    public GatewayFilter apply(CheckAuthGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

                //获取请求参数name的值
                String name = exchange.getRequest().getQueryParams().getFirst("name");

                if (StringUtils.isNotBlank(name)) {
                    if ("dugu".equals(name)) {
                        return chain.filter(exchange);
                    } else {
                        //不匹配，直接转发到百度
                        setResponseStatus(exchange, new HttpStatusHolder(HttpStatus.SEE_OTHER, null));
                        final ServerHttpResponse response = exchange.getResponse();
                        response.getHeaders().set(HttpHeaders.LOCATION, "https://www.baidu.com");
                        return response.setComplete();
                    }
                }

                return chain.filter(exchange);
            }
        };
    }

    @Data
    public static class Config {

        private String name;

    }

}

