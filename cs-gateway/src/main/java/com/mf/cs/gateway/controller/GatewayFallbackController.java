package com.mf.cs.gateway.controller;

import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GatewayFallbackController {

    @RequestMapping("/fallback")
    public Result<Map<String,Object>> defaultfallback() {
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","服务超时降级");
        map.put("data",null);

        return Result.success(map);
    }
}
