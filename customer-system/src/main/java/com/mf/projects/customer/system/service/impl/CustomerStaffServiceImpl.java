package com.mf.projects.customer.system.service.impl;

import com.mf.projects.cs.infrastructure.page.PageObject;
import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import com.mf.projects.customer.system.service.ICustomerStaffService;

import java.util.List;

public class CustomerStaffServiceImpl implements ICustomerStaffService {
    @Override
    public PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex) {
        return null;
    }

    @Override
    public List<CustomerStaff> findCustomerStaffs() {
        return null;
    }
}
