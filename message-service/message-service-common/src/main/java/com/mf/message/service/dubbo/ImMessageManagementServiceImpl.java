package com.mf.message.service.dubbo;

import com.mf.cs.project.message.domain.ImMessageDto;
import com.mf.cs.project.message.service.ImMessageManagementService;
import com.mf.message.service.converter.ImMessageConverter;
import com.mf.message.service.service.ImMessageService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DubboService(version = "${message.service.version}")
public class ImMessageManagementServiceImpl implements ImMessageManagementService {

    @Autowired
    private ImMessageService messageService;

    @Override
    public void saveMessage(ImMessageDto messageDto) {
        messageService.saveImMessage(ImMessageConverter.INSTANCE.convertToEntity(messageDto));
    }

    @Override
    public List<ImMessageDto> findMessages() {
        return ImMessageConverter.INSTANCE.convertToDtoList(messageService.findMessages());
    }

    @Override
    public List<ImMessageDto> findMessageByUserId(Long id) {

        return ImMessageConverter.INSTANCE.convertToDtoList(messageService.findMessageByUserId(id));
    }
}
