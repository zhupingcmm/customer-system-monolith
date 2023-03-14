package com.mf.im.client.service.impl;

import com.mf.im.client.client.NettyClient;
import com.mf.im.client.service.ImRouterService;
import com.mf.im.client.service.LoginService;
import com.mf.im.client.util.FutureUtil;
import com.mf.projects.im.handler.IMLoginRequest;
import com.mf.projects.im.handler.IMLoginResponse;
import com.mf.projects.im.handler.IMServerInfo;
import io.netty.channel.ChannelFuture;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.concurrent.ExecutorService;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {



    @Autowired
    private ImRouterService imRouterService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NettyClient nettyClient;

    @Autowired
    private ExecutorService executorService;

    @Override
    public void login(IMLoginRequest request) {
        val imRouterUri = imRouterService.getImRouterUri();
        val serverInfo = imRouterService.getIMServerInfo(imRouterUri);
        loginRoute(imRouterUri, serverInfo, request);
        executorService.submit(() -> {
            nettyClient.start(serverInfo, request);
        });
    }

    @Override
    public void logout(String userId) {
        // 关闭 netty 客户端
        val channelFuture = FutureUtil.getFuture(userId);
        channelFuture.channel().close();

        // 登出 im-router
        val imRouterUri = imRouterService.getImRouterUri();
        val serverInfo = imRouterService.getIMServerInfo(imRouterUri);
        imRouterService.logout(userId, serverInfo);
    }


    private void loginRoute (URI imRouterUri, IMServerInfo imServerInfo, IMLoginRequest request){
        request.setServerHost(imServerInfo.getHost());
        request.setHttpPort(imServerInfo.getHttpPort());
        request.setNettyPort(imServerInfo.getNettyPort());
        val response = restTemplate.postForObject(imRouterUri + "/auth/login", request, IMLoginResponse.class);

        if (response.success() || response.relogin()) {
            log.info("{}:({}) login im-router success ", request.getUserName(), request.getUserId());
        } else {
            log.info("{}:({}) login im-router failed", request.getUserName(), request.getUserId());
        }
    }
}
