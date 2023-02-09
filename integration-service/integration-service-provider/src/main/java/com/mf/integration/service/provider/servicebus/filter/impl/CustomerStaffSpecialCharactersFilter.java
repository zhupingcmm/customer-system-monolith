package com.mf.integration.service.provider.servicebus.filter.impl;

import com.mf.integration.service.provider.servicebus.filter.AbstractCustomerStaffFilter;
import domain.PlatformCustomerStaff;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerStaffSpecialCharactersFilter extends AbstractCustomerStaffFilter {

    @Override
    public PlatformCustomerStaff execute(PlatformCustomerStaff customerStaff) {
        if (customerStaff.getStaffName().matches("[\u4e00-\u9fa5]")) {
            log.info("this staff is wrong [{}], and will be filtered", customerStaff.getStaffName());
            return null;
        }
        if (getNext() != null) {
            return getNext().execute(customerStaff);
        }
        return customerStaff;
    }
}
