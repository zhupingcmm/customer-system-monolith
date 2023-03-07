package com.mf.ticket.service.converter;

import com.mf.ticket.service.controller.vo.TicketVO;
import com.mf.ticket.service.entity.CustomerTicket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerTicketConverter {
    CustomerTicketConverter INSTANCE = Mappers.getMapper(CustomerTicketConverter.class);

    CustomerTicket convertToEntity(TicketVO ticketVO);

}
