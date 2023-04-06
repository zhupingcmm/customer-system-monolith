package com.mf.cs.ticket.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mf.cs.ticket.service.entity.CustomerTicket;
import com.mf.cs.ticket.service.mapper.CustomerTicketMapper;
import com.mf.cs.ticket.service.service.CustomerTicketService;
import org.springframework.stereotype.Service;

@Service
public class CustomerTicketServiceImpl extends ServiceImpl<CustomerTicketMapper, CustomerTicket> implements CustomerTicketService {
    @Override
    public void insertTicket(CustomerTicket customerTicket) {
        this.save(customerTicket);

    }
}
