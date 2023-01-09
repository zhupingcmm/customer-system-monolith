package com.mf.outsouring.system.hangzhou.controller;

import com.mf.outsouring.system.hangzhou.controller.vo.HangZhouCustomerStaffVO;
import com.mf.outsouring.system.hangzhou.converter.HangZhouCustomerStaffConverter;
import com.mf.outsouring.system.hangzhou.service.HangZhouCustomerStaffService;
import com.mf.projects.cs.infrastructure.vo.Result;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;

@EnableWebMvc
@RestController
@RequestMapping("/customerstatffs/hangzhou")
public class HangZhouStaffController {
    @Autowired
    private HangZhouCustomerStaffService customerStaffService;


    @PostMapping("/")
    public Result<HangZhouCustomerStaffVO> addCustomerStaff(@RequestBody HangZhouCustomerStaffVO customerStaffVO){
        return Result.success(customerStaffService.createCustomerStaff(HangZhouCustomerStaffConverter.INSTANCE.convertToEntity(customerStaffVO)));
    }


    @PutMapping("/")
    public Result<HangZhouCustomerStaffVO> updateCustomerStaff(@RequestBody HangZhouCustomerStaffVO customerStaffVO) {
        return Result.success(customerStaffService.updateCustomerStaff(HangZhouCustomerStaffConverter.INSTANCE.convertToEntity(customerStaffVO)));
    }


    @DeleteMapping("/")
    public Result<HangZhouCustomerStaffVO> deleteCustomerStaff(@RequestParam("id") Long id) {
        return Result.success(customerStaffService.deleteCustomerStaffById(id));
    }

    @GetMapping("/")
    public Result<HangZhouCustomerStaffVO> getAllCustomerStaffs() {
        val customerStaffs = customerStaffService.findAllCustomerStaffs();
        return Result.success(HangZhouCustomerStaffConverter.INSTANCE.convertToListVO(customerStaffs));
    }

    @GetMapping("/updated")
    public Result<HangZhouCustomerStaffVO> getCustomerStaffsByUpdateTime(@RequestParam("updateTime") Long updatedTime) {
        Date updateTimeForQuery = new Date(updatedTime);
        val staffs = customerStaffService.findCustomerStaffByUpdateTime(updateTimeForQuery);
        return Result.success(HangZhouCustomerStaffConverter.INSTANCE.convertToListVO(staffs));
    }

}
