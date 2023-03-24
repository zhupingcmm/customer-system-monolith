package com.mf.integration.service.provider.service.impl;

import com.mf.integration.service.api.dto.OutsourcingSystemDTO;
import com.mf.integration.service.provider.feign.CustomerStaffControllerApi;
import com.mf.integration.service.provider.service.CustomerService;
import com.mf.integration.service.provider.servicebus.common.CustomerStaff;
import com.mf.integration.service.provider.servicebus.endpoint.CustomerStaffEndpoint;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerStaffEndpoint<PlatformCustomerStaff> customerStaffEndpoint;

    @Autowired
    private CustomerStaffControllerApi customerStaffControllerApi;
    @Override
    public void push(CustomerStaff customerStaff, OutsourcingSystemDTO outsourcingSystemDTO) {
        val platformCustomerStaff = customerStaffEndpoint.getPlatformCustomerStaff(outsourcingSystemDTO, customerStaff);
        customerStaffControllerApi.addCustomerStaff(platformCustomerStaff);

    }
}
