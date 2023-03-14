package com.mf.im.client.controller;

import com.mf.im.client.service.LoginService;
import com.mf.projects.im.handler.IMLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public void login(@RequestBody IMLoginRequest request) {
        loginService.login(request);
    }

    @DeleteMapping("/logout/{userid}")
    public void logout(@PathVariable("userid") String userId) {
        loginService.logout(userId);
    }
}
