package com.mf.message.service.converter;

import com.mf.cs.project.message.domain.ImMessageDto;
import com.mf.message.service.entity.ImMessage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ImMessageConverter {
    ImMessageConverter INSTANCE = Mappers.getMapper(ImMessageConverter.class);

    // entity -> dto
    ImMessageDto convertToDto(ImMessage message);

    //
    List<ImMessageDto> convertToDtoList(List<ImMessage> messages);

    ImMessage convertToEntity(ImMessageDto dto);

}
