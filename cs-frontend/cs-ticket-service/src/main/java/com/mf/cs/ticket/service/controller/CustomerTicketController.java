package com.mf.cs.ticket.service.controller;

import com.mf.cs.ticket.service.controller.vo.CustomerTicketVO;
import com.mf.cs.ticket.service.converter.CustomerTicketConverter;
import com.mf.cs.ticket.service.service.CustomerTicketService;
import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class CustomerTicketController {

    @Autowired
    private CustomerTicketService customerTicketService;
    @PostMapping
    public Result<Boolean> addTicket(@RequestBody CustomerTicketVO vo) {
        customerTicketService.insertTicket(CustomerTicketConverter.INSTANCE.convertToEntity(vo));
        return Result.success(true);
    }
}
