package com.mf.projects.customer.system.servicebus.filter;

import com.mf.projects.customer.system.entity.staff.CustomerStaff;

public interface CustomerStaffFilter {

    CustomerStaff execute(CustomerStaff customerStaff);

    void setNext(CustomerStaffFilter filter);

    CustomerStaffFilter getNext();

    CustomerStaffFilter getLast();
}
