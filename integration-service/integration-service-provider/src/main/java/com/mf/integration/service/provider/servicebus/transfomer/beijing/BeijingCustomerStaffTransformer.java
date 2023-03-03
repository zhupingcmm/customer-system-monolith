package com.mf.integration.service.provider.servicebus.transfomer.beijing;



import com.mf.integration.service.provider.servicebus.router.beijing.dto.BeijingCustomerStaff;
import com.mf.integration.service.provider.servicebus.transfomer.CustomerStaffTransformer;

import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "beijing_transformer")
public class BeijingCustomerStaffTransformer implements CustomerStaffTransformer<BeijingCustomerStaff> {
    @Override
    public List<PlatformCustomerStaff> transformCustomerStaffs(Long systemId, List<BeijingCustomerStaff> staffs) {
        return null;
    }

    @Override
    public PlatformCustomerStaff transformCustomerStaff(Long systemId, BeijingCustomerStaff staff) {
        return null;
    }
}
