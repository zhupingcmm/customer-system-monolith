package com.mf.projects.customer.system.servicebus.transfomer.hangzhou;

import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import com.mf.projects.customer.system.servicebus.router.hangzhou.dto.HangzhouCustomerStaff;
import com.mf.projects.customer.system.servicebus.transfomer.CustomerStaffTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "hangzhou_transformer")
public class HangzhouCustomerStaffTransformer implements CustomerStaffTransformer<HangzhouCustomerStaff> {
    @Override
    public List<CustomerStaff> transformCustomerStaffs(List<HangzhouCustomerStaff> staffs) {
        return null;
    }
}
