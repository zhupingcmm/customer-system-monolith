package com.mf.projects.customer.system.servicebus.transfomer.shanghai;

import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import com.mf.projects.customer.system.servicebus.router.shanghai.dto.ShanghaiCustomerStaff;
import com.mf.projects.customer.system.servicebus.transfomer.CustomerStaffTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "shanghai_transformer")
public class ShanghaiCustomerStaffTransformer implements CustomerStaffTransformer<ShanghaiCustomerStaff> {
    @Override
    public List<CustomerStaff> transformCustomerStaffs(List<ShanghaiCustomerStaff> staffs) {
        return null;
    }
}
