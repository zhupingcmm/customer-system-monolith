package com.mf.cs.business.feignclient;

import com.mf.cs.business.controller.vo.CustomerTicketVO;
import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "ticket-service", path = "/ticket")
public interface TicketClient {

    @PostMapping
    Result<Boolean> addTicket(@RequestBody CustomerTicketVO vo);
}
