package com.mf.integration.service.provider.servicebus.transfomer;

import domain.PlatformCustomerStaff;

import java.util.List;

public interface CustomerStaffTransformer<T> {
    List<PlatformCustomerStaff> transformCustomerStaffs(Long systemId, List<T> staffs);
}
