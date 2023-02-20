package com.mf.outsouring.system.hangzhou.service.impl;

import com.mf.outsouring.system.hangzhou.entity.HangZhouCustomerStaff;
import com.mf.outsouring.system.hangzhou.repository.HangzhouCustomerStaffRepository;
import com.mf.outsouring.system.hangzhou.service.HangZhouCustomerStaffService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<HangZhouCustomerStaff> findCustomerStaffs(Integer currentPage, Integer pageSize) {
        List<HangZhouCustomerStaff> customerStaffs = new ArrayList<>();
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        val page = customerStaffRepository.findAll(pageable);
        customerStaffs.addAll(page.getContent());
        return customerStaffs;
    }

    @Override
    public Long getCustomerCount() {
        return customerStaffRepository.count();
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
