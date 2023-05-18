package com.mf.cs.business.feignclient.fallback;

import com.mf.cs.business.controller.vo.CustomerTicketVO;
import com.mf.cs.business.feignclient.TicketClient;
import com.mf.projects.cs.infrastructure.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TicketClientFallback implements TicketClient {
    @Override
    public Result<Boolean> addTicket(CustomerTicketVO vo) {
        log.info("addTicket fallback!!!!!");
        return Result.success(false);
    }
}
