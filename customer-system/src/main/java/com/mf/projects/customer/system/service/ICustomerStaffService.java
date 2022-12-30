package com.mf.projects.customer.system.service;

import com.mf.projects.cs.infrastructure.page.PageObject;
import com.mf.projects.customer.system.entity.staff.CustomerStaff;

import java.util.List;

public interface ICustomerStaffService {

    PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex);

    List<CustomerStaff> findCustomerStaffs();


    PageObject<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex);

    CustomerStaff findCustomerStaffById(Long staffId);



    Boolean createCustomerStaff(CustomerStaff customerStaff);

    Boolean updateCustomerStaff(CustomerStaff customerStaff);

    Boolean deleteCustomerStaffById(Long staffId);

    void syncOutsourcingCustomerStaffsBySystemId(Long systemId);
}
