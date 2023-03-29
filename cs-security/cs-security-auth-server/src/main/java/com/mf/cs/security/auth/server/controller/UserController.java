package com.mf.cs.security.auth.server.controller;

import com.mf.cs.security.auth.server.controller.vo.UserVO;
import com.mf.cs.security.auth.server.converter.UserConverter;
import com.mf.cs.security.auth.server.service.UserService;
import com.mf.projects.cs.infrastructure.vo.Result;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Result<UserVO> addUser(@RequestBody UserVO userVO) {
        val user = UserConverter.INSTANCE.convertToEntity(userVO);

        return Result.success(UserConverter.INSTANCE.convertToVo(userService.addUser(user)));
    }
}
