package com.mf.im.client.feign;

import com.mf.im.client.config.FeignConfiguration;
import com.mf.im.client.feign.fallback.LoginControllerFeignClientFallback;
import com.mf.projects.cs.infrastructure.api.ApiConstants;
import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.im.handler.IMLoginRequest;
import com.mf.projects.im.handler.IMLoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(path = "/auth", value = ApiConstants.IM_ROUTER, configuration = FeignConfiguration.class)
public interface LoginControllerFeignClient {
    @PostMapping("/login")
    Result<IMLoginResponse> login(@RequestBody IMLoginRequest request);

    @PostMapping("/logout/{userid}")
    void logout(@PathVariable("userid") String userId);


    @GetMapping("/users")
    Result<List<IMLoginRequest>> getAllIMLoginRequests();
}
