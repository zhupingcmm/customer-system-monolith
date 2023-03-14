package com.mf.projects.customer.system.job;

import com.mf.projects.customer.system.feign.CustomerStaffControllerApi;
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
    private CustomerStaffControllerApi customerStaffControllerApi;

    @XxlJob("syncCustomerStaff")
    public ReturnT<String> syncCustomerStaff(){
        val jobParam = XxlJobHelper.getJobParam();
        log.info("start sync customer staff data from outsourcing system and system id is {}", jobParam);
        customerStaffControllerApi.syncOutsourcingCustomerStaffsBySystemId(Long.parseLong(jobParam));
        return ReturnT.SUCCESS;
    }
}
