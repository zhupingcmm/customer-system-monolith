package com.mf.integration.service.provider.servicebus.filter;



import domain.PlatformCustomerStaff;

public interface CustomerStaffFilter {

    PlatformCustomerStaff execute(PlatformCustomerStaff customerStaff);

    void setNext(CustomerStaffFilter filter);

    CustomerStaffFilter getNext();

    CustomerStaffFilter getLast();
}
