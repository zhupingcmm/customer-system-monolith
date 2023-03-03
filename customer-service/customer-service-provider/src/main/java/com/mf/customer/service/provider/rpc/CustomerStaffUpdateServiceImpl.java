package com.mf.customer.service.provider.rpc;

import com.mf.customer.service.provider.converter.CustomerIntegrationConverter;
import com.mf.customer.service.provider.service.ICustomerStaffService;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import service.CustomerStaffUpdateService;

@DubboService(version = "${customer.service.update.version}")
public class CustomerStaffUpdateServiceImpl implements CustomerStaffUpdateService {

    @Autowired
    ICustomerStaffService customerStaffService;
    @Override
    public void updateCustomerStaff(PlatformCustomerStaff customerStaff) {
        customerStaffService.createCustomerStaff(CustomerIntegrationConverter.INSTANCE.convertToCustomerStaff(customerStaff));
    }
}
