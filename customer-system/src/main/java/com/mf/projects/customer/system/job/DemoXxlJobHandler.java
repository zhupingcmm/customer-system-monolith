package com.mf.projects.customer.system.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class DemoXxlJobHandler {

    @XxlJob("demoXxlJobHandler")
    public ReturnT<String> demoXxlJobHandler(){
        log.info("date {}", new Date());
        return ReturnT.SUCCESS;
    }

}
