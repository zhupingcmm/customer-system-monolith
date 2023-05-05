package com.mf.cs.business.feignclient.fallback;

import com.mf.cs.business.controller.vo.CustomerTicketVO;
import com.mf.cs.business.feignclient.TicketClient;
import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.stereotype.Component;

@Component
public class TicketClientFallback implements TicketClient {
    @Override
    public Result<Boolean> addTicket(CustomerTicketVO vo) {
        return Result.success(false);
    }
}
