package com.mf.im.event.service;

import com.mf.im.event.entity.ImMessage;

import java.util.List;

public interface ImMessageService {

    void saveImMessage(ImMessage message);

    List<ImMessage> findMessages();

    List<ImMessage> findMessageByUserId(Long id);
}
