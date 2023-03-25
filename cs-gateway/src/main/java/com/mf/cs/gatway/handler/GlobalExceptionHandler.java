package com.mf.cs.gatway.handler;

import com.alibaba.fastjson.JSON;
import com.mf.projects.cs.infrastructure.vo.Result;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Order(-1)
@Component
public class GlobalExceptionHandler implements ErrorWebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        val response = exchange.getResponse();

        if (response.isCommitted()) {
            // 直接返回
            return Mono.error(ex);
        }

        Result<?> result;
        if (ex instanceof ResponseStatusException) {
            // 处理网关默认抛出的异常 ResponseStatusException
            result = responseStatusExceptionHandler(exchange, (ResponseStatusException) ex);
        } else {
            result = globalExceptionHandler(exchange, ex);
        }

        return writeResult(exchange, result);
    }

    private Result<?> globalExceptionHandler(ServerWebExchange exchange, Throwable ex) {
        ServerHttpRequest request = exchange.getRequest();
        log.error("[globalExceptionHandler][uri({}/{}) 发生异常]", request.getURI(), request.getMethod(), ex);
        return Result.error(500, "服务网关全局异常");

    }

    private Result<?> responseStatusExceptionHandler(ServerWebExchange exchange, ResponseStatusException ex) {
        val request = exchange.getRequest();
        log.error("[responseStatusExceptionHandler][uri {}/{}] 发生异常", request.getURI(), request.getMethod(), ex);

        return Result.error(ex.getRawStatusCode(), ex.getReason());
    }

    public  Mono<Void> writeResult(ServerWebExchange exchange, Object object) {
        // 设置header
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
        // 设置body
        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory bufferFactory = response.bufferFactory();
            try {
                return bufferFactory.wrap(JSON.toJSONBytes(object));
            } catch (Exception ex) {
                ServerHttpRequest request = exchange.getRequest();
                log.error("[writeResult][uri({}/{}) 发生异常]", request.getURI(), request.getMethod(), ex);
                return bufferFactory.wrap(new byte[0]);
            }
        }));
    }
}
