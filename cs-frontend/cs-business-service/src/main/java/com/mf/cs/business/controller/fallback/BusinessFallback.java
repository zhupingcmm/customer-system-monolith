package com.mf.cs.business.controller.fallback;

import com.mf.cs.business.controller.vo.CustomerTicketVO;
import com.mf.projects.cs.infrastructure.vo.Result;

public class BusinessFallback {
    public static Result<Boolean> generateTicketFallback(CustomerTicketVO customerTicketVO) {
        return Result.success(false);
    }
}
