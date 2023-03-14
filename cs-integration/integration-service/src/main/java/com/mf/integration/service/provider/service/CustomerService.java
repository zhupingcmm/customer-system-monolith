package com.mf.integration.service.provider.service;


import com.mf.integration.service.api.dto.OutsourcingSystemDTO;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;


public interface CustomerService {
    void updateCustomerStaff(PlatformCustomerStaff customerStaff, OutsourcingSystemDTO outsourcingSystemDTO);
}
