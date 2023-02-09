package com.mf.integration.service.provider.servicebus.endpoint;




import domain.OutsourcingSystemDTO;

import java.util.List;

public interface CustomerStaffEndpoint<T> {

    List<T> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystem);
}
