package com.mf.integration.service.provider.servicebus.transfomer;



import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;

import java.util.List;

public interface CustomerStaffTransformer<T> {
    List<PlatformCustomerStaff> transformCustomerStaffs(Long systemId, List<T> staffs);

    PlatformCustomerStaff transformCustomerStaff(Long systemId, T staff);
}
