package com.mf.customer.service.provider.integration.mock;

import domain.OutsourcingSystemDTO;
import domain.PlatformCustomerStaff;
import lombok.extern.slf4j.Slf4j;
import service.CustomerStaffIntegrationService;

import java.util.List;

@Slf4j
public class CustomerStaffIntegrationServiceMock implements CustomerStaffIntegrationService<PlatformCustomerStaff> {
    @Override
    public List<PlatformCustomerStaff> fetchCustomerStaffs(Integer currentPage, Integer pageSize, OutsourcingSystemDTO outsourcingSystemDTO) {
        return null;
    }

    @Override
    public Long getCustomerStaffCount(OutsourcingSystemDTO outsourcingSystemDTO) {
        return null;
    }

}
