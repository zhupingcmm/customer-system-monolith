package com.mf.cs.chat.service.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mf.projects.cs.infrastructure.vo.Result;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/chats")
@Slf4j
public class ChatController {

    @GetMapping
    public Result<?> testChat() {
        return Result.success("Hello");
    }

    @GetMapping("/{id}")
    @SentinelResource(value = "getChatById", blockHandler = "handleBlock")
    public Result<?> getChatById(@PathVariable int id) {
        return Result.success(id);
    }

    public Result<?> handleBlock(int id, BlockException ex) {
        log.info("{} 被限流了", id);
        return Result.success(id);
    }

}
