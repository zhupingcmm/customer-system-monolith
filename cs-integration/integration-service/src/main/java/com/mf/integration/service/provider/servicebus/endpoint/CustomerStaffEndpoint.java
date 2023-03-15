package com.mf.integration.service.provider.servicebus.endpoint;


import com.mf.integration.service.api.dto.OutsourcingSystemDTO;
import com.mf.integration.service.provider.servicebus.common.CustomerStaff;


import java.util.List;

public interface CustomerStaffEndpoint<T> {

    List<T> fetchCustomerStaffs(Integer currentPage, Integer pageSize, OutsourcingSystemDTO outsourcingSystem);

    Long getCustomerStaffCount(OutsourcingSystemDTO outsourcingSystemDTO);

    T getPlatformCustomerStaff(OutsourcingSystemDTO outsourcingSystemDTO, CustomerStaff customerStaff);


}
