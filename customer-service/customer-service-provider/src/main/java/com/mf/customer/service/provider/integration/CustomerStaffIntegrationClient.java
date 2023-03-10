package com.mf.customer.service.provider.integration;

import com.mf.customer.service.provider.converter.CustomerIntegrationConverter;
import com.mf.customer.service.provider.entity.staff.CustomerStaff;
import com.mf.customer.service.provider.entity.tenant.OutsourcingSystem;
import lombok.val;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import service.CustomerStaffIntegrationService;

import java.util.List;

@Component
public class CustomerStaffIntegrationClient {

    // timeout retries 服务容错
    // mock 服务降级
    @DubboReference(version = "${integration.service.version}", timeout = 3000, retries = 3, mock = "com.mf.customer.service.provider.integration.mock.CustomerStaffIntegrationServiceMock", check = false)
    private CustomerStaffIntegrationService integrationService;

    public List<CustomerStaff> getCustomerStaffs(Integer currentPage, Integer pageSize,  OutsourcingSystem outsourcingSystem){
        val dto = CustomerIntegrationConverter.INSTANCE.convertToDto(outsourcingSystem);

        val staffs = integrationService.fetchCustomerStaffs( currentPage, pageSize, dto);

        return CustomerIntegrationConverter.INSTANCE.convertCustomerStaffListDTO(staffs);

    }


    public Long getCustomerStaffCount(OutsourcingSystem outsourcingSystem){
        val dto = CustomerIntegrationConverter.INSTANCE.convertToDto(outsourcingSystem);
        return integrationService.getCustomerStaffCount(dto);
    }


}
