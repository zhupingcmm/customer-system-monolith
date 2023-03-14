package com.mf.integration.service.provider.servicebus.transfomer.shanghai;



import com.mf.integration.service.provider.servicebus.router.shanghai.dto.ShanghaiCustomerStaff;
import com.mf.integration.service.provider.servicebus.transfomer.CustomerStaffTransformer;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "shanghai_transformer")
public class ShanghaiCustomerStaffTransformer implements CustomerStaffTransformer<ShanghaiCustomerStaff> {
    @Override
    public List<PlatformCustomerStaff> transformCustomerStaffs(Long systemId, List<ShanghaiCustomerStaff> staffs) {
        return null;
    }

    @Override
    public PlatformCustomerStaff transformCustomerStaff(Long systemId, ShanghaiCustomerStaff staff) {
        return null;
    }
}
