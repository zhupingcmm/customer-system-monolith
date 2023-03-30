package com.mf.cs.gateway.filter;

import com.mf.projects.cs.infrastructure.api.ApiConstants;
import com.mf.projects.cs.infrastructure.exception.BizException;
import com.mf.projects.cs.infrastructure.exception.MessageCode;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Slf4j
@Component
public class AuthFiler implements GlobalFilter{

    private static final String ACCESS_TOKEN = "access_token";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String ACCESS_CODE = "access_code";
    private static final String ADD_USER_PATH = "/user";

    private static final String OAUTH_TOKEN = "/oauth/token";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        val request = exchange.getRequest();
        val accessToken = request.getHeaders().get(ACCESS_TOKEN);
        val refreshToken = request.getHeaders().get(REFRESH_TOKEN);
        val accessCode = request.getHeaders().get(ACCESS_CODE);
        val params = request.getQueryParams();

        val authorizationToken = request.getHeaders().get("authorization");

        if (authorizationToken == null) {

            if (!isGeneratorTokenRequest(request)) {
                throw new BizException(MessageCode.INVALID_TOKEN, "无效token");
            }
        }
        return chain.filter(exchange);
    }



    private boolean isGeneratorTokenRequest(ServerHttpRequest request) {
        return request.getMethod() == HttpMethod.POST && request.getPath().toString().equals(OAUTH_TOKEN);
    }
}
