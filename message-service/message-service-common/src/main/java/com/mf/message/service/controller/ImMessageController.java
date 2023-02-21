package com.mf.message.service.controller;

import com.mf.cs.project.message.domain.ImMessageDto;
import com.mf.message.service.converter.ImMessageConverter;
import com.mf.message.service.entity.ImMessage;
import com.mf.message.service.service.ImMessageService;
import com.mf.projects.cs.infrastructure.vo.Result;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class ImMessageController {

    @Autowired
    private ImMessageService imMessageService;

    @PostMapping("/")
    public void saveImMessage(@RequestBody ImMessageDto dto) {
        imMessageService.saveImMessage(ImMessageConverter.INSTANCE.convertToEntity(dto));
    }

    @GetMapping()
    public Result<List<ImMessage>> findMessages(){
        val messages = imMessageService.findMessages();
        return Result.success(ImMessageConverter.INSTANCE.convertToDtoList(messages));
    }

    @GetMapping("/{id}")
    public Result<List<ImMessage>> findMessageByUserId(@PathVariable("id") Long id){
        val messages = imMessageService.findMessageByUserId(id);

        return Result.success(ImMessageConverter.INSTANCE.convertToDtoList(messages));
    }

}
