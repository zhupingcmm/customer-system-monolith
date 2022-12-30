package com.mf.projects.customer.system.service;

import com.mf.projects.cs.infrastructure.page.PageObject;
import com.mf.projects.customer.system.entity.staff.CustomerStaff;

import java.util.List;

public interface ICustomerStaffService {

    PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex);

    List<CustomerStaff> findCustomerStaffs();


    Boolean createCustomerStaff(CustomerStaff customerStaff);
}
