package com.mf.projects.customer.system.servicebus.transfomer;

import com.mf.projects.customer.system.entity.staff.CustomerStaff;

import java.util.List;

public interface CustomerStaffTransformer<T> {
    List<CustomerStaff> transformCustomerStaffs(List<T> staffs);
}
