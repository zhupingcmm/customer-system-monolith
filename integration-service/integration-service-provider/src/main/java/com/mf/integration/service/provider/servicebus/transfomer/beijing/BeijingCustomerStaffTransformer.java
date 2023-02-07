package com.mf.integration.service.provider.servicebus.transfomer.beijing;



import com.mf.integration.service.provider.servicebus.router.beijing.dto.BeijingCustomerStaff;
import com.mf.integration.service.provider.servicebus.transfomer.CustomerStaffTransformer;
import domain.PlatformCustomerStaff;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "beijing_transformer")
public class BeijingCustomerStaffTransformer implements CustomerStaffTransformer<BeijingCustomerStaff> {
    @Override
    public List<PlatformCustomerStaff> transformCustomerStaffs(List<BeijingCustomerStaff> staffs) {
        return null;
    }
}
