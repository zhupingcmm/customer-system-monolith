package com.mf.projects.customer.system.controller.webmvc;

import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.customer.system.controller.vo.CustomerStaffVO;
import com.mf.projects.customer.system.converter.CustomerStaffConverter;
import com.mf.projects.customer.system.service.ICustomerStaffService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerStaffs")
public class CustomerStaffController {


    @Autowired
    private ICustomerStaffService customerStaffService;

    @PostMapping("/")
    public Result<Long> addCustomerStaff(@RequestBody CustomerStaffVO customerStaffVO) {
        val customerStaff = CustomerStaffConverter.INSTANCE.covertToEntity(customerStaffVO);
        customerStaffService.createCustomerStaff(customerStaff);
        return Result.success(customerStaff.getId());
    }

}
