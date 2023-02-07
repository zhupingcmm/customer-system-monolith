package com.mf.customer.service.provider.rpc;

import com.mf.customer.service.provider.service.ICustomerStaffService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import service.CustomerStaffSyncService;

@DubboService(version = "${customer.service.version}")
public class CustomerStaffSyncServiceImpl implements CustomerStaffSyncService {

    @Autowired
    ICustomerStaffService customerStaffService;

    @Override
    public void syncOutsourcingCustomerStaffsBySystemId(Long systemId) {
        customerStaffService.syncOutsourcingCustomerStaffsBySystemId(systemId);
    }
}
