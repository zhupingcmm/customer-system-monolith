package com.mf.message.service.service;

import com.mf.message.service.entity.ImMessage;

import java.util.List;

public interface ImMessageService {

    void saveImMessage(ImMessage message);

    List<ImMessage> findMessages();

    List<ImMessage> findMessageByUserId(Long id);
}
