package com.mf.projects.customer.system.servicebus.filter.impl;

import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import com.mf.projects.customer.system.servicebus.filter.AbstractCustomerStaffFilter;

import java.util.Objects;

public class CustomerStaffEmptyFilter extends AbstractCustomerStaffFilter {
    @Override
    public CustomerStaff execute(CustomerStaff customerStaff) {
        if (Objects.isNull(customerStaff.getStaffName())){
            return null;
        }
        if (getNext() != null) {
            return getNext().execute(customerStaff);
        }
        return customerStaff;
    }
}
