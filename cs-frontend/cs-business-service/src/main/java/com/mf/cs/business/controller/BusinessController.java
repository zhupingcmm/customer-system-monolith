package com.mf.cs.business.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.mf.cs.business.controller.fallback.BusinessFallback;
import com.mf.cs.business.controller.vo.CustomerTicketVO;
import com.mf.cs.business.service.BusinessService;
import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping
    @SentinelResource(value = "generateTicket", fallbackClass = BusinessFallback.class, fallback = "generateTicketFallback")
    public Result<Boolean> generateTicket (@RequestBody CustomerTicketVO customerTicketVO) {
        businessService.generateTicket(customerTicketVO);
        return Result.success(true);
    }

}
