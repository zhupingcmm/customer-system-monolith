package com.mf.projects.customer.system.feign.fallback;

import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.customer.system.feign.CustomerStaffControllerApi;

public class CustomerStaffControllerApiImpl implements CustomerStaffControllerApi {
    @Override
    public Result<Boolean> syncOutsourcingCustomerStaffsBySystemId(Long systemId) {
        return null;
    }
}
