package com.mf.ticket.service.service;

import com.mf.ticket.service.entity.LocalCustomerStaff;

public interface LocalCustomerStaffService {
    void insertLocalCustomerStaff(LocalCustomerStaff localCustomerStaff);

    void updateLocalCustomerStaff(LocalCustomerStaff localCustomerStaff);

    void deleteLocalCustomerStaff(LocalCustomerStaff localCustomerStaff);

    LocalCustomerStaff findLocalCustomerStaffByStaffId(Long staffId);
}
