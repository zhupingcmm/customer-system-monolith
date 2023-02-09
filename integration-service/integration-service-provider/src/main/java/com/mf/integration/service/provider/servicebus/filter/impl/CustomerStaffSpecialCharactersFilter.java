package com.mf.integration.service.provider.servicebus.filter.impl;

import com.mf.integration.service.provider.servicebus.filter.AbstractCustomerStaffFilter;
import domain.PlatformCustomerStaff;

public class CustomerStaffSpecialCharactersFilter extends AbstractCustomerStaffFilter {

    @Override
    public PlatformCustomerStaff execute(PlatformCustomerStaff customerStaff) {
        if (customerStaff.getStaffName().matches("[\u4e00-\u9fa5]")) {
            return null;
        }
        if (getNext() != null) {
            return getNext().execute(customerStaff);
        }
        return customerStaff;
    }
}
