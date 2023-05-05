package com.mf.im.client.feign.fallback;

import com.mf.im.client.feign.ServerInfoControllerFeignClient;
import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.im.handler.IMServerInfo;
import org.springframework.stereotype.Component;

@Component
public class ServerInfoControllerFeignClientFallback implements ServerInfoControllerFeignClient {
    @Override
    public Result<IMServerInfo> getServerInfo() {
        IMServerInfo imServerInfo = new IMServerInfo();

        return Result.success(imServerInfo);
    }
}
