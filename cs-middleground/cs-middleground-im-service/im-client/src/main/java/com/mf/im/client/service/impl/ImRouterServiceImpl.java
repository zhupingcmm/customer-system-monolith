package com.mf.im.client.service.impl;

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
    private RestTemplate restTemplate;

    @Override
    public URI getImRouterUri() {
        val instance = loadBalancerClient.choose("im-router");
        return instance.getUri();
    }

    @Override
    public IMServerInfo getIMServerInfo(URI uri) {
        return restTemplate.getForObject(uri + "/serverinfo", IMServerInfo.class);
    }

    @Override
    public void logout(String userId, IMServerInfo imServerInfo) {
        restTemplate.postForObject("http://" + imServerInfo.getHost() + ":" + imServerInfo.getHttpPort() + "/auth/logout/" + userId, null, Object.class );
    }
}
