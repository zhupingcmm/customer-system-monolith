package com.mf.projects.customer.system.servicebus.filter;

import com.mf.projects.customer.system.entity.staff.CustomerStaff;

public class CustomerStaffFilterChain {

    private CustomerStaffFilter chain;

    public void addFilter(CustomerStaffFilter filter) {
        if (chain == null) {
            chain = filter;
        } else {
            chain.getLast().setNext(chain);
        }
    }


    public CustomerStaff execute(CustomerStaff customerStaff) {
        if (chain != null) {
            return chain.execute(customerStaff);
        }
        return null;
    }
}
