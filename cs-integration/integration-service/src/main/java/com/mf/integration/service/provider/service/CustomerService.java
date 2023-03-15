package com.mf.integration.service.provider.service;


import com.mf.integration.service.api.dto.OutsourcingSystemDTO;
import com.mf.integration.service.provider.servicebus.common.CustomerStaff;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;


public interface CustomerService {
    void push(CustomerStaff customerStaff, OutsourcingSystemDTO outsourcingSystemDTO);
}
