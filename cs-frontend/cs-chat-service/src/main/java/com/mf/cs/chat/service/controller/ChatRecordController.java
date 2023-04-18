package com.mf.cs.chat.service.controller;

import com.mf.cs.chat.service.controller.vo.ChatRecordVO;
import com.mf.cs.chat.service.converter.ChatRecordConverter;
import com.mf.cs.chat.service.service.IChatRecordService;
import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatrecord")
public class ChatRecordController {

    @Autowired
    IChatRecordService chatRecordService;

    @PostMapping
    public Result<Boolean> insertChatRecord(@RequestBody ChatRecordVO chatRecordVO) {

//        chatRecordService.insertChat(ChatRecordConverter.INSTANCE.convertToEntity(chatRecordVO));
        chatRecordService.generateChatRecord(ChatRecordConverter.INSTANCE.convertToEntity(chatRecordVO));
        return Result.success(true);
    }
}
