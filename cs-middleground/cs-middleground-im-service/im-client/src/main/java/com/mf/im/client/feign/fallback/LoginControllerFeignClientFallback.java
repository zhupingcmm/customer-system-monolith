package com.mf.im.client.feign.fallback;

import com.mf.im.client.feign.LoginControllerFeignClient;
import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.im.handler.IMLoginRequest;
import com.mf.projects.im.handler.IMLoginResponse;

import java.util.List;

public class LoginControllerFeignClientFallback implements LoginControllerFeignClient {
    @Override
    public Result<IMLoginResponse> login(IMLoginRequest request) {
        return null;
    }

    @Override
    public void logout(String userId) {

    }

    @Override
    public Result<List<IMLoginRequest>> getAllIMLoginRequests() {
        return null;
    }
}
