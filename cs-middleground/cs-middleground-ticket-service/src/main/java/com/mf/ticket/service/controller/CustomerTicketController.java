package com.mf.ticket.service.controller;

import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.ticket.service.controller.vo.TicketVO;
import com.mf.ticket.service.service.CustomerTicketService;
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

    @PostMapping("/")
    public Result<Boolean> insertTicket(@RequestBody TicketVO ticketVO){
        customerTicketService.insertTicket(ticketVO);
        return Result.success(true);
    }
}
