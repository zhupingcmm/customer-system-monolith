package com.mf.im.router.controller;

import com.mf.projects.im.handler.IMServerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/serverinfo")
public class ServerInfoController {

    @GetMapping
    public IMServerInfo getServerInfo() {
        IMServerInfo imServerInfo = new IMServerInfo();
        imServerInfo.setHost("127.0.0.1");
        imServerInfo.setNettyPort(8888);
        imServerInfo.setHttpPort(18001);
        return imServerInfo;
    }
}
