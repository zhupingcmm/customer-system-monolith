package com.mf.cs.ticket.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mf.cs.ticket.service.entity.CustomerTicket;

public interface CustomerTicketService extends IService<CustomerTicket> {
    void insertTicket(CustomerTicket customerTicket);
}
