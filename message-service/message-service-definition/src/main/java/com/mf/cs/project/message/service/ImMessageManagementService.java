package com.mf.cs.project.message.service;

import com.mf.cs.project.message.domain.ImMessageDto;

import java.util.List;

public interface ImMessageManagementService {

    void saveMessage(ImMessageDto messageDto);

    List<ImMessageDto> findMessages();

    List<ImMessageDto> findMessageByUserId(Long id);

}
