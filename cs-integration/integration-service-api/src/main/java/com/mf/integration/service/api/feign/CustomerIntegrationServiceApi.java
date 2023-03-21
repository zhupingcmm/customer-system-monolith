package com.mf.integration.service.api.feign;

import com.mf.integration.service.api.config.FeignConfiguration;
import com.mf.integration.service.api.dto.OutsourcingSystemDTO;
import com.mf.integration.service.api.feign.impl.CustomerIntegrationServiceApiImpl;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = ApiConstants.SERVICE_NAME, fallback = CustomerIntegrationServiceApiImpl.class, configuration = FeignConfiguration.class, path = "/staffs")
public interface CustomerIntegrationServiceApi {

    @PostMapping("/{currentpage}/{pagesize}")
    Result<List<PlatformCustomerStaff>> fetchCustomerStaffs(@PathVariable("currentpage") Integer currentPage, @PathVariable("pagesize") Integer pageSize, @RequestBody OutsourcingSystemDTO outsourcingSystemDTO);
    @PostMapping("/counts")
    Result<Long> getCustomerStaffCount(@RequestBody OutsourcingSystemDTO outsourcingSystemDTO);
}
