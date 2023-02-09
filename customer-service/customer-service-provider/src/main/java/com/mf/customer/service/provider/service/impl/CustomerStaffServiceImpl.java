package com.mf.customer.service.provider.service.impl;



import com.mf.customer.service.provider.entity.staff.CustomerStaff;
import com.mf.customer.service.provider.integration.CustomerStaffIntegrationClient;
import com.mf.customer.service.provider.mapper.CustomerStaffMapper;
import com.mf.customer.service.provider.service.ICustomerStaffService;
import com.mf.customer.service.provider.service.IOutsourcingSystemService;
import com.mf.projects.cs.infrastructure.page.PageObject;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerStaffServiceImpl implements ICustomerStaffService {

    @Autowired
    private CustomerStaffMapper customerStaffMapper;

    @Autowired
    private IOutsourcingSystemService outsourcingSystemService;

    @Autowired
    private CustomerStaffIntegrationClient integrationClient;
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
        // 获取外部系统信息
        val outsourcingSystem = outsourcingSystemService.findOutsourcingSystemById(systemId);
        // 通过外部系统信息，获取外部客户系统的客户信息
        List<CustomerStaff> customerStaffs = integrationClient.getCustomerStaffs(outsourcingSystem);
        // 更新DB
        customerStaffMapper.createCustomerStaffs(customerStaffs);
    }
}
