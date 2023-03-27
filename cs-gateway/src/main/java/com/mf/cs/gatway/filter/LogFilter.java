package com.mf.cs.gatway.filter;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LogFilter implements GlobalFilter {
    private static final String START_TIME = "START_TIME";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        val request = exchange.getRequest();
        val serviceName = exchange.getAttribute("org.springframework.cloud.gateway.support.ServerWebExchangeUtils.gatewayPredicateMatchedPathRouteIdAttr");
        exchange.getAttributes().put(START_TIME, System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            long takeTime = System.currentTimeMillis() - (long)exchange.getAttribute(START_TIME);
            log.info("[{}] {} {} with params {} take time {} ms", request.getMethod(), serviceName, request.getPath(), request.getQueryParams(), takeTime);
        }));
    }
}
