package com.mf.ticket.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mf.ticket.service.controller.vo.TicketVO;
import com.mf.ticket.service.converter.CustomerTicketConverter;
import com.mf.ticket.service.entity.CustomerTicket;
import com.mf.ticket.service.mapper.CustomerTicketMapper;
import com.mf.ticket.service.service.CustomerTicketService;
import org.springframework.stereotype.Service;

@Service
public class CustomerTicketServiceImpl extends ServiceImpl<CustomerTicketMapper, CustomerTicket> implements CustomerTicketService {


    @Override
    public void insertTicket(TicketVO ticketVO) {
        baseMapper.insert(CustomerTicketConverter.INSTANCE.convertToEnrtity(ticketVO));
    }
}
