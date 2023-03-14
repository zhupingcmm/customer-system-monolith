package com.mf.integration.service.provider.controller;

import com.alibaba.fastjson.JSON;
import com.mf.integration.service.api.dto.OutsourcingSystemDTO;
import com.mf.integration.service.provider.servicebus.endpoint.CustomerStaffEndpoint;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import com.mf.projects.cs.infrastructure.vo.Result;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/staffs")
public class CustomerStaffController {

    @Autowired
    private CustomerStaffEndpoint<PlatformCustomerStaff> customerStaffEndpoint;

    @PostMapping("/{currentpage}/{pagesize}")
    public Result<List<PlatformCustomerStaff>> fetchCustomerStaffs(@PathVariable("currentpage") Integer currentPage, @PathVariable("pagesize") Integer pageSize, @RequestBody OutsourcingSystemDTO outsourcingSystemDTO) {
        val customerStaffs = customerStaffEndpoint.fetchCustomerStaffs(currentPage, pageSize, outsourcingSystemDTO);
        return Result.success(customerStaffs);
    }

    @PostMapping("/counts")
    public Result<Long> getCustomerStaffCount(@RequestBody OutsourcingSystemDTO outsourcingSystemDTO) {
        val counts = customerStaffEndpoint.getCustomerStaffCount(outsourcingSystemDTO);
        return Result.success(counts);
    }
}
