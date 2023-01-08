package com.mf.outsouring.system.hangzhou.service.impl;

import com.mf.outsouring.system.hangzhou.entity.HangZhouCustomerStaff;
import com.mf.outsouring.system.hangzhou.repository.HangzhouCustomerStaffRepository;
import com.mf.outsouring.system.hangzhou.service.HangZhouCustomerStaffService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HangZhouCustomerStaffServiceImpl implements HangZhouCustomerStaffService {

    @Autowired

    private HangzhouCustomerStaffRepository customerStaffRepository;

    @Override
    public List<HangZhouCustomerStaff> findAllCustomerStaffs() {
        return customerStaffRepository.findByIsDeletedFalse();
    }

    @Override
    public List<HangZhouCustomerStaff> findCustomerStaffByUpdateTime(Date updateTime) {
        return customerStaffRepository.findByUpdateAtAfter(updateTime);
    }

    @Override
    public HangZhouCustomerStaff createCustomerStaff(HangZhouCustomerStaff customerStaff) {
        return customerStaffRepository.save(customerStaff);
    }

    @Override
    public HangZhouCustomerStaff updateCustomerStaff(HangZhouCustomerStaff customerStaff) {
        return customerStaffRepository.save(customerStaff);

    }

    @Override
    public HangZhouCustomerStaff deleteCustomerStaffById(Long id) {
        val customerStaff = new HangZhouCustomerStaff().setIsDeleted(true).setId(id);
        return customerStaffRepository.save(customerStaff);
    }
}
