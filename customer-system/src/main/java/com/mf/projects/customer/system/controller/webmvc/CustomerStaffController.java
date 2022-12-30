package com.mf.projects.customer.system.controller.webmvc;

import com.mf.projects.cs.infrastructure.page.PageObject;
import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.customer.system.controller.vo.CustomerStaffVO;
import com.mf.projects.customer.system.converter.CustomerStaffConverter;
import com.mf.projects.customer.system.service.ICustomerStaffService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("/")
    public Result<Boolean> updateCustomerStaff(@RequestBody CustomerStaffVO customerStaffVO){
        val customerStaff = CustomerStaffConverter.INSTANCE.covertToEntity(customerStaffVO);
        val isUpdate = customerStaffService.updateCustomerStaff(customerStaff);
        return Result.success(isUpdate);
    }


    @PutMapping("/status")
    public Result<Boolean> updateCustomerStaffStatus(@RequestBody CustomerStaffVO customerStaffVO){
        val customerStaff = CustomerStaffConverter.INSTANCE.covertToEntity(customerStaffVO);
        val isUpdate = customerStaffService.updateCustomerStaff(customerStaff);
        return Result.success(isUpdate);
    }

    @GetMapping("/{staffId}")
    public Result<CustomerStaffVO> findCustomerStaffById(@PathVariable("staffId") Long staffId) {
        val customerStaff = customerStaffService.findCustomerStaffById(staffId);
        val customerStaffVO = CustomerStaffConverter.INSTANCE.covertToVO(customerStaff);
        return Result.success(customerStaffVO);
    }

    @GetMapping("/page/{pagesize}/{pageindex}")
    public Result<PageObject<CustomerStaffVO>> findCustomerStaffs(@PathVariable("pagesize") Long pageSize, @PathVariable("pageindex") Long pageIndex) {

        val pagedCustomerStaff = customerStaffService.findCustomerStaffs(pageSize, pageIndex);
        val customerStaffVOs = CustomerStaffConverter.INSTANCE.covertToVOs(pagedCustomerStaff.getList());

        val result = new PageObject<CustomerStaffVO>()
                .setList(customerStaffVOs)
                .setPageIndex(pagedCustomerStaff.getPageIndex())
                .setPageSize(pagedCustomerStaff.getPageSize())
                .setTotal(pagedCustomerStaff.getTotal());

        return Result.success(result);
    }

    @DeleteMapping("/{staffId}")
    public Result<Boolean> deleteCustomerStaffById(@PathVariable("staffId") Long staffId) {
        val isDeleted = customerStaffService.deleteCustomerStaffById(staffId);
        return Result.success(isDeleted);

    }

    @GetMapping("/sync/{systemId}")
    public Result<Boolean> syncOutsourcingCustomerStaffsBySystemId(@PathVariable("systemId") Long systemId) {
        customerStaffService.syncOutsourcingCustomerStaffsBySystemId(systemId);
        return Result.success(true);
    }



}
