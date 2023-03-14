package com.mf.integration.service.provider.servicebus.filter.impl;

import com.mf.integration.service.provider.servicebus.filter.AbstractCustomerStaffFilter;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;

import java.util.Objects;

public class CustomerStaffEmptyFilter extends AbstractCustomerStaffFilter {
    @Override
    public PlatformCustomerStaff execute(PlatformCustomerStaff customerStaff) {
        if (Objects.isNull(customerStaff.getStaffName())){
            return null;
        }
        if (getNext() != null) {
            return getNext().execute(customerStaff);
        }
        return customerStaff;
    }
}
