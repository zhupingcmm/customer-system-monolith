package com.mf.im.router.controller;

import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.im.handler.IMServerInfo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/serverinfo")
public class ServerInfoController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping
    public IMServerInfo getServerInfo() {
        val instance = loadBalancerClient.choose("im-server");
        val nettyPort = instance.getMetadata().get("netty-port");
        IMServerInfo imServerInfo = new IMServerInfo();
        imServerInfo.setHost(instance.getHost());
        imServerInfo.setNettyPort(Integer.parseInt(nettyPort));
        imServerInfo.setHttpPort(instance.getPort());
        return imServerInfo;
    }


}
