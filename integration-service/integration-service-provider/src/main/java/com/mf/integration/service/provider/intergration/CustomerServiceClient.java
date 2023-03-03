package com.mf.integration.service.provider.intergration;

import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import service.CustomerStaffSyncService;
import service.CustomerStaffUpdateService;

@Component
public class CustomerServiceClient {

    @DubboReference(version = "${customer.service.update.version}", timeout = 3000, retries = 3, check = false)
    private CustomerStaffUpdateService customerStaffUpdateService;

    public void updateCustomerStaff(PlatformCustomerStaff customerStaff){
        customerStaffUpdateService.updateCustomerStaff(customerStaff);
    }
}
