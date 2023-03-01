package com.mf.im.router.controller;

import com.mf.im.router.service.LoginService;
import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.im.handler.IMLoginRequest;
import com.mf.projects.im.handler.IMLoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Qualifier("redis")
    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public IMLoginResponse login(@RequestBody IMLoginRequest request) {
        IMLoginResponse response = new IMLoginResponse();
        if (loginService.isLogin(request.getUserId())){
            response.setCode("2001");
            response.setMsg("重复登陆");
            return response;
        }

        loginService.login(request);
        log.info("{}({}): login success ", request.getUserName(), request.getUserId());
        return response;
    }

    @PostMapping("/logout/{userid}")
    public void logout(@PathVariable("userid") String userId){
        loginService.logout(userId);
        log.info("{} 登出系统", userId);
    }


    @GetMapping("/users")
    public Result<List<IMLoginRequest>> getAllIMLoginRequests(){
       return Result.success(loginService.getAllIMLoginRequests());
    }

}
