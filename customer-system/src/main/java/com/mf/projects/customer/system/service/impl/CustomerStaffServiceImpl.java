package com.mf.projects.customer.system.service.impl;

import com.mf.projects.cs.infrastructure.page.PageObject;
import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import com.mf.projects.customer.system.mapper.CustomerStaffMapper;
import com.mf.projects.customer.system.service.ICustomerStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerStaffServiceImpl implements ICustomerStaffService {

    @Autowired
    private CustomerStaffMapper customerStaffMapper;
    @Override
    public PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex) {
        return null;
    }

    @Override
    public List<CustomerStaff> findCustomerStaffs() {
        return null;
    }

    @Override
    public PageObject<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex) {
        return null;
    }

    @Override
    public CustomerStaff findCustomerStaffById(Long staffId) {
        return customerStaffMapper.findCustomerStaffById(staffId);
    }

    @Override
    public Boolean createCustomerStaff(CustomerStaff customerStaff) {
        customerStaffMapper.createCustomerStaff(customerStaff);
        return true;
    }

    @Override
    public Boolean updateCustomerStaff(CustomerStaff customerStaff) {
        return null;
    }

    @Override
    public Boolean deleteCustomerStaffById(Long staffId) {
        return null;
    }

    @Override
    public void syncOutsourcingCustomerStaffsBySystemId(Long systemId) {

    }
}
