package com.mf.cs.chat.service.controller;

import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/chats")
public class ChatController {

    @GetMapping
    public Result<?> testChat() {
        return Result.success("Hello");
    }

}
