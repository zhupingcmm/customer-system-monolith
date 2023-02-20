package com.mf.outsouring.system.hangzhou.service;

import com.mf.outsouring.system.hangzhou.entity.HangZhouCustomerStaff;

import java.util.Date;
import java.util.List;

public interface HangZhouCustomerStaffService {

    List<HangZhouCustomerStaff> findAllCustomerStaffs();

    List<HangZhouCustomerStaff> findCustomerStaffs(Integer currentPage, Integer pageSize);

    Long getCustomerCount();

    List<HangZhouCustomerStaff> findCustomerStaffByUpdateTime(Date updateTime);

    HangZhouCustomerStaff createCustomerStaff(HangZhouCustomerStaff customerStaff);

    HangZhouCustomerStaff updateCustomerStaff(HangZhouCustomerStaff customerStaff);

    HangZhouCustomerStaff deleteCustomerStaffById(Long id);
}
