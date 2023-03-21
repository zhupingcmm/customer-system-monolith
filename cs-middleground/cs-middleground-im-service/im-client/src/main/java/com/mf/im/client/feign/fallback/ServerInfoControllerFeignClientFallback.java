package com.mf.im.client.feign.fallback;

import com.mf.im.client.feign.ServerInfoControllerFeignClient;
import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.im.handler.IMServerInfo;

public class ServerInfoControllerFeignClientFallback implements ServerInfoControllerFeignClient {
    @Override
    public Result<IMServerInfo> getServerInfo() {
        return null;
    }
}
