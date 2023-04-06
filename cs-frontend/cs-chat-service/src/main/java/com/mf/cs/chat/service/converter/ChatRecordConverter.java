package com.mf.cs.chat.service.converter;

import com.mf.cs.chat.service.controller.vo.ChatRecordVO;
import com.mf.cs.chat.service.entity.ChatRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatRecordConverter {
    ChatRecordConverter INSTANCE = Mappers.getMapper(ChatRecordConverter.class);


    // vo -> entity
    ChatRecord convertToEntity(ChatRecordVO vo);

    // entity -> vo
    ChatRecordVO convertToVO(ChatRecord entity);
}
