package com.mf.cs.ticket.service.converter;

import com.mf.cs.ticket.service.controller.vo.CustomerTicketVO;
import com.mf.cs.ticket.service.entity.CustomerTicket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerTicketConverter {
    CustomerTicketConverter INSTANCE = Mappers.getMapper(CustomerTicketConverter.class);

    // vo -> entity
    CustomerTicket convertToEntity(CustomerTicketVO vo);

    // entity -> vo
    CustomerTicket convertToVO(CustomerTicket entity);
}
