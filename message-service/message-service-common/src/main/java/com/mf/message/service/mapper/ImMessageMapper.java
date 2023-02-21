package com.mf.message.service.mapper;

import com.mf.message.service.entity.ImMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImMessageMapper {
    void saveImMessage(ImMessage message);

    List<ImMessage> findMessages();

    List<ImMessage> findMessageByUserId(Long id);
}
