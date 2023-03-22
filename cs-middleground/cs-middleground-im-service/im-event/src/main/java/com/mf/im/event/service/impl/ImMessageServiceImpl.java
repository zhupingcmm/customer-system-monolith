package com.mf.im.event.service.impl;


import com.mf.im.event.entity.ImMessage;
import com.mf.im.event.mapper.ImMessageMapper;
import com.mf.im.event.service.ImMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImMessageServiceImpl implements ImMessageService {

    @Autowired
    private ImMessageMapper imMessageMapper;

    @Override
    public void saveImMessage(ImMessage message) {
        imMessageMapper.saveImMessage(message);
    }

    @Override
    public List<ImMessage> findMessages() {
        return imMessageMapper.findMessages();
    }

    @Override
    public List<ImMessage> findMessageByUserId(Long id) {
        return imMessageMapper.findMessageByUserId(id);
    }
}
