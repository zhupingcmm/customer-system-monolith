package com.mf.im.router.controller;

import com.mf.im.router.service.ServerInfoService;
import com.mf.projects.cs.infrastructure.api.ApiConstants;
import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.im.handler.IMServerInfo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/serverinfo")
public class ServerInfoController {

    private static final String NETTY_PORT = "netty-port";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ServerInfoService serverInfoService;

    @GetMapping
    public Result<IMServerInfo> getServerInfo() {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        throw new RuntimeException("an");
        // 从 nacos 中获取 im-server 节点信息
//        val instance = loadBalancerClient.choose(ApiConstants.IM_SERVER);
//        val nettyPort = instance.getMetadata().get(NETTY_PORT);
//
//        // 封装 server 的信息
//        IMServerInfo imServerInfo = new IMServerInfo();
//        imServerInfo.setHost(instance.getHost());
//        imServerInfo.setNettyPort(Integer.parseInt(nettyPort));
//        imServerInfo.setHttpPort(instance.getPort());
//        return Result.success(imServerInfo);
    }

    @PostMapping("/{userid}")
    public Result<Boolean> addServerInfo(@PathVariable("userid") String userId, @RequestBody IMServerInfo serverInfo) {
        serverInfoService.addServerInfo(userId, serverInfo);
        return Result.success(true);
    }

    @GetMapping("/{userid}")
    public Result<IMServerInfo> getServerInfoByUserId(@PathVariable("userid") String userId) {
        return Result.success(serverInfoService.getServerInfo(userId));
    }


}
