package com.mf.integration.service.api.feign.impl;

import com.mf.integration.service.api.dto.OutsourcingSystemDTO;
import com.mf.integration.service.api.feign.CustomerIntegrationServiceApi;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import com.mf.projects.cs.infrastructure.vo.Result;

import java.util.List;

public class CustomerIntegrationServiceApiImpl implements CustomerIntegrationServiceApi {


    @Override
    public Result<List<PlatformCustomerStaff>> fetchCustomerStaffs(Integer currentPage, Integer pageSize, OutsourcingSystemDTO outsourcingSystemDTO) {
        return null;
    }

    @Override
    public Result<Long> getCustomerStaffCount(OutsourcingSystemDTO outsourcingSystemDTO) {
        return null;
    }
}
