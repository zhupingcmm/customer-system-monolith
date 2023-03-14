package com.mf.integration.service.provider.servicebus.filter;


import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;

public interface CustomerStaffFilter {

    PlatformCustomerStaff execute(PlatformCustomerStaff customerStaff);

    void setNext(CustomerStaffFilter filter);

    CustomerStaffFilter getNext();

    CustomerStaffFilter getLast();
}
