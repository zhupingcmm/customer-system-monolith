package com.mf.ticket.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mf.ticket.service.controller.vo.TicketVO;
import com.mf.ticket.service.converter.CustomerTicketConverter;
import com.mf.ticket.service.entity.CustomerTicket;
import com.mf.ticket.service.mapper.CustomerTicketMapper;
import com.mf.ticket.service.service.CustomerTicketService;
import com.mf.ticket.service.service.LocalCustomerStaffService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerTicketServiceImpl extends ServiceImpl<CustomerTicketMapper, CustomerTicket> implements CustomerTicketService {

    @Qualifier("redis_local_customer")
    @Autowired
    private LocalCustomerStaffService localCustomerStaffService;

    @Override
    public void insertTicket(TicketVO ticketVO) {
        val staff = localCustomerStaffService.findLocalCustomerStaffByStaffId(ticketVO.getStaffId());
        if (staff == null) {
            throw new RuntimeException();
        }

        baseMapper.insert(CustomerTicketConverter.INSTANCE.convertToEntity(ticketVO));
    }
}
