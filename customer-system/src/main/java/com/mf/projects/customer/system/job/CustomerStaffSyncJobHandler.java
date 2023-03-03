package com.mf.projects.customer.system.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import service.CustomerStaffSyncService;

@Slf4j
@Component
public class CustomerStaffSyncJobHandler {

    @DubboReference(version = "${customer.service.sync.version}")
    private CustomerStaffSyncService customerStaffSyncService;

    @XxlJob("syncCustomerStaff")
    public ReturnT<String> syncCustomerStaff(){
        val jobParam = XxlJobHelper.getJobParam();
        log.info("start sync customer staff data from outsourcing system and system id is {}", jobParam);
        customerStaffSyncService.syncOutsourcingCustomerStaffsBySystemId(Long.parseLong(jobParam));
        return ReturnT.SUCCESS;
    }
}
