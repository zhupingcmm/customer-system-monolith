package com.mf.integration.service.provider.rpc;

import com.mf.integration.service.provider.servicebus.endpoint.CustomerStaffEndpoint;
import domain.OutsourcingSystemDTO;
import domain.PlatformCustomerStaff;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import service.CustomerStaffIntegrationService;

import java.util.List;

@DubboService(version = "${integration.service.version}")
public class CustomerStaffIntegrationServiceImpl implements CustomerStaffIntegrationService<PlatformCustomerStaff> {

    @Autowired
    private CustomerStaffEndpoint<PlatformCustomerStaff> customerStaffEndpoint;

    @Override
    public List<PlatformCustomerStaff> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystemDTO) {
        return customerStaffEndpoint.fetchCustomerStaffs(outsourcingSystemDTO);
    }
}