package com.mf.im.router.message;

import com.mf.cs.project.message.domain.ImMessageDto;
import com.mf.cs.project.message.service.ImMessageManagementService;
import com.mf.projects.im.dto.P2PChatRequest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

@Component
public class MessageClient {

    @DubboReference(version = "${message.service.version}")
    private ImMessageManagementService imMessageManagementService;

    public void saveMessage(P2PChatRequest request){
        ImMessageDto imMessageDto = new ImMessageDto();
        imMessageDto.setMessage(request.getMsg());
        imMessageDto.setFromUserId(Long.parseLong(request.getFromUserId()));
        imMessageDto.setToUserId(Long.parseLong(request.getToUserId()));

        imMessageManagementService.saveMessage(imMessageDto);

    }



}
