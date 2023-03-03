package com.mf.integration.service.provider.service;


import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import domain.OutsourcingSystemDTO;

public interface CustomerService {
    void updateCustomerStaff(PlatformCustomerStaff customerStaff, OutsourcingSystemDTO outsourcingSystemDTO);
}
