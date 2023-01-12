package com.mf.outsouring.system.beijing.controller;

import com.mf.outsouring.system.beijing.controller.vo.BeijingCustomerStaffVO;
import com.mf.outsouring.system.beijing.converter.BeijingCustomerStaffConverter;
import com.mf.outsouring.system.beijing.service.BeijingCustomerService;
import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerstaffs/beijing")
public class BeijingCustomerSystemController {

    @Autowired
    private BeijingCustomerService beijingCustomerService;



    @PostMapping
    public Result<Boolean> addCustomerStaff (@RequestBody BeijingCustomerStaffVO beijingCustomerStaffVO) {
       return Result.success(beijingCustomerService.createCustomerStaff(BeijingCustomerStaffConverter.INSTANCE.convertToEntity(beijingCustomerStaffVO)));
    }

    @PutMapping
    public Result<Boolean> updateCustomerStaff(@RequestBody BeijingCustomerStaffVO beijingCustomerStaffVO) {
        return Result.success(beijingCustomerService.updateCustomerStaff(BeijingCustomerStaffConverter.INSTANCE.convertToEntity(beijingCustomerStaffVO)));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteCustomerStaffById(@PathVariable Long id) {
        return Result.success(beijingCustomerService.deleteCustomerStaffById(id));
    }

    @GetMapping("/staffs")
    public Result<List<BeijingCustomerStaffVO>> findAllCustomerStaffs () {
        return Result.success(BeijingCustomerStaffConverter.INSTANCE.convertToVOList(beijingCustomerService.findAllCustomerStaffs()));
    }

    @GetMapping("/staffs/{updatedTime}")
    public  Result<List<BeijingCustomerStaffVO>> findCustomerStaffsByUpdatedTime(@PathVariable Long updatedTime) {
        return Result.success(BeijingCustomerStaffConverter.INSTANCE.convertToVOList(beijingCustomerService.findCustomerStaffsByUpdatedTime(updatedTime)));
    }
}
