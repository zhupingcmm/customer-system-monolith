package com.mf.im.client.feign;

import com.mf.im.client.config.FeignConfiguration;
import com.mf.im.client.feign.fallback.ServerInfoControllerFeignClientFallback;
import com.mf.projects.cs.infrastructure.api.ApiConstants;

import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.im.handler.IMServerInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = ApiConstants.IM_ROUTER, path = "/serverinfo", fallback = ServerInfoControllerFeignClientFallback.class, configuration = FeignConfiguration.class)
public interface ServerInfoControllerFeignClient {
    @GetMapping
    Result<IMServerInfo> getServerInfo();
}
