package com.mf.projects.customer.system.job;

import com.mf.projects.customer.system.service.ICustomerStaffService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerStaffSyncJobHandler {


    @Autowired
    private ICustomerStaffService customerStaffService;

    @XxlJob("syncCustomerStaff")
    public ReturnT<String> syncCustomerStaff(){
        log.info("start sync customer staff from outsourcing system");
        val jobParam = XxlJobHelper.getJobParam();
        customerStaffService.syncOutsourcingCustomerStaffsBySystemId(Long.parseLong(jobParam));
        return ReturnT.SUCCESS;
    }
}
