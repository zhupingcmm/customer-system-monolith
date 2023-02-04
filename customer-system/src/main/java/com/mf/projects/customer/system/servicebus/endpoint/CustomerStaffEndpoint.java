package com.mf.projects.customer.system.servicebus.endpoint;

import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import com.mf.projects.customer.system.entity.tenant.OutsourcingSystem;

import java.util.List;

public interface CustomerStaffEndpoint {

    List<CustomerStaff> fetchCustomerStaffs(OutsourcingSystem outsourcingSystem);
}
