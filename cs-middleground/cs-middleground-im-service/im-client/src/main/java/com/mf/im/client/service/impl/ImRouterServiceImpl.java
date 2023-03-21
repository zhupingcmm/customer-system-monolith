package com.mf.im.client.service.impl;

import com.mf.im.client.feign.LoginControllerFeignClient;
import com.mf.im.client.feign.ServerInfoControllerFeignClient;
import com.mf.im.client.service.ImRouterService;
import com.mf.projects.im.handler.IMServerInfo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ImRouterServiceImpl implements ImRouterService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ServerInfoControllerFeignClient serverInfoControllerFeignClient;

    @Autowired
    private LoginControllerFeignClient loginControllerFeignClient;



    @Override
    public URI getImRouterUri() {
        val instance = loadBalancerClient.choose("im-router");
        return instance.getUri();
    }

    @Override
    public IMServerInfo getIMServerInfo() {
        return serverInfoControllerFeignClient.getServerInfo().getData();
    }

    @Override
    public void logout(String userId) {
        loginControllerFeignClient.logout(userId);
    }
}
