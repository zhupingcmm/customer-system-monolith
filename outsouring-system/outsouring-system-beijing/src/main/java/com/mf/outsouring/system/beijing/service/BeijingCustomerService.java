package com.mf.outsouring.system.beijing.service;

import com.mf.outsouring.system.beijing.entity.BeijingCustomerStaff;

import java.util.List;

public interface BeijingCustomerService {

    List<BeijingCustomerStaff> findAllCustomerStaffs();

    List<BeijingCustomerStaff> findCustomerStaffsByUpdatedTime(Long updatedTime);

    Boolean createCustomerStaff(BeijingCustomerStaff customerStaff);

    Boolean updateCustomerStaff(BeijingCustomerStaff customerStaff);

    Boolean deleteCustomerStaffById(Long id);
}
