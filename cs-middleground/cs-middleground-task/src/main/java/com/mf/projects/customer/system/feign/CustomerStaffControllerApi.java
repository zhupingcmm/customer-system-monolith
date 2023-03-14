package com.mf.projects.customer.system.feign;

import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.customer.system.config.FeignConfiguration;
import com.mf.projects.customer.system.feign.fallback.CustomerStaffControllerApiImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.mf.projects.customer.system.feign.ApiConstants.SERVICE_NAME;


@FeignClient(value = SERVICE_NAME, path = "/customerStaffs", fallback = CustomerStaffControllerApiImpl.class, configuration = FeignConfiguration.class)
public interface CustomerStaffControllerApi {

    @GetMapping("/sync/{systemId}")
    Result<Boolean> syncOutsourcingCustomerStaffsBySystemId(@PathVariable("systemId") Long systemId);
}
