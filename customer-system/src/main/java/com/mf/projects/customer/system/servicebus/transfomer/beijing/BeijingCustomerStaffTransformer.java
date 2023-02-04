package com.mf.projects.customer.system.servicebus.transfomer.beijing;

import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import com.mf.projects.customer.system.servicebus.router.beijing.dto.BeijingCustomerStaff;
import com.mf.projects.customer.system.servicebus.transfomer.CustomerStaffTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "beijing_transformer")
public class BeijingCustomerStaffTransformer implements CustomerStaffTransformer<BeijingCustomerStaff> {
    @Override
    public List<CustomerStaff> transformCustomerStaffs(List<BeijingCustomerStaff> staffs) {
        return null;
    }
}
