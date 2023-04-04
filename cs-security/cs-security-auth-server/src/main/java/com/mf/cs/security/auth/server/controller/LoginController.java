package com.mf.cs.security.auth.server.controller;

import com.mf.projects.cs.infrastructure.vo.Result;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        val result = restTemplate.getForObject("http://localhost:18001/oauth/authorize/?client_id=cs_client&grant_type=authorization_code&response_type=code&redirect_uri=http://localhost:18001/login/callback", String.class);
        log.info("data {}", result);
        return result;
    }

    @GetMapping("/callback")
    public Result<OAuth2AccessToken> callback(@RequestParam(required = false) String code) {
        log.info("code {} ", code);
        val object = restTemplate.postForObject("http://localhost:18001/oauth/token?client_id=cs_client&client_secret=cs_secret&grant_type=authorization_code&code="+code+"&redirect_uri=http://localhost:18001/login/callback", null, OAuth2AccessToken.class);
        log.info("object {}", object);
        return Result.success(object);

    }
}
