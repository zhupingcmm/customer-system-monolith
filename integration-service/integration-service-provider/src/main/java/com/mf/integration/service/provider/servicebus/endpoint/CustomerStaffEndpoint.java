package com.mf.integration.service.provider.servicebus.endpoint;




import domain.OutsourcingSystemDTO;
import domain.PlatformCustomerStaff;

import java.util.List;

public interface CustomerStaffEndpoint {

    List<PlatformCustomerStaff> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystem);
}
