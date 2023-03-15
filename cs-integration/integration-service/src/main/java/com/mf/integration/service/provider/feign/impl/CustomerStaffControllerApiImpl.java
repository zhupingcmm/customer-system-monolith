package com.mf.integration.service.provider.feign.impl;

import com.mf.integration.service.provider.feign.CustomerStaffControllerApi;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import com.mf.projects.cs.infrastructure.vo.Result;

public class CustomerStaffControllerApiImpl implements CustomerStaffControllerApi {

    @Override
    public Result<Long> addCustomerStaff(PlatformCustomerStaff customerStaffVO) {
        return null;
    }

}
