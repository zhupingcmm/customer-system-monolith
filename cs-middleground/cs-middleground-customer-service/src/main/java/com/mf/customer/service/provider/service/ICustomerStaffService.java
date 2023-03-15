package com.mf.customer.service.provider.service;


import com.mf.customer.service.provider.entity.staff.CustomerStaff;
import com.mf.projects.cs.infrastructure.page.PageObject;

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
