package com.mf.integration.service.provider.feign;

import com.mf.integration.service.provider.feign.impl.CustomerStaffControllerApiImpl;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.mf.projects.cs.infrastructure.api.ApiConstants.CUSTOMER_SERVICE;

@FeignClient(value = CUSTOMER_SERVICE, path = "/customerStaffs", fallback = CustomerStaffControllerApiImpl.class)
public interface CustomerStaffControllerApi {

    @PostMapping("/")
    Result<Long> addCustomerStaff(@RequestBody PlatformCustomerStaff customerStaffVO);
}
