package com.mf.projects.customer.system.service.impl;

import com.mf.projects.cs.infrastructure.page.PageObject;
import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import com.mf.projects.customer.system.mapper.CustomerStaffMapper;
import com.mf.projects.customer.system.service.ICustomerStaffService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerStaffServiceImpl implements ICustomerStaffService {

    @Autowired
    private CustomerStaffMapper customerStaffMapper;
    @Override
    public PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex) {
        Long start = (pageIndex -1) * pageSize;

        val customerStaffs = customerStaffMapper.findCustomerStaffs(start, pageSize);
        return new PageObject<CustomerStaff>()
                .setTotal((long) customerStaffs.size())
                .setList(customerStaffs)
                .setPageIndex(pageIndex)
                .setPageSize(pageSize);
    }

    @Override
    public List<CustomerStaff> findCustomerStaffs() {
        return customerStaffMapper.findAllCustomerStaffs();
    }

    @Override
    public PageObject<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex) {
        Long start = (pageIndex -1) * pageSize;
        val staffs = customerStaffMapper.findCustomerStaffsByName(staffName, start, pageSize);

        return new PageObject<CustomerStaff>()
                .setTotal((long) staffs.size())
                .setList(staffs)
                .setPageIndex(pageIndex)
                .setPageSize(pageSize);
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
        customerStaffMapper.updateCustomerStaff(customerStaff);
        return true;
    }

    @Override
    public Boolean deleteCustomerStaffById(Long staffId) {
        customerStaffMapper.deleteCustomerStaffById(staffId);
        return true;
    }

    @Override
    public void syncOutsourcingCustomerStaffsBySystemId(Long systemId) {

    }
}
