package com.mf.integration.service.provider.servicebus.endpoint;



import com.mf.integration.service.provider.servicebus.router.hangzhou.dto.HangzhouCustomerStaff;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import domain.OutsourcingSystemDTO;

import java.util.List;

public interface CustomerStaffEndpoint<T> {

    List<T> fetchCustomerStaffs(Integer currentPage, Integer pageSize, OutsourcingSystemDTO outsourcingSystem);

    Long getCustomerStaffCount(OutsourcingSystemDTO outsourcingSystemDTO);

    PlatformCustomerStaff getPlatformCustomerStaff(OutsourcingSystemDTO outsourcingSystemDTO, HangzhouCustomerStaff customerStaff);


}
