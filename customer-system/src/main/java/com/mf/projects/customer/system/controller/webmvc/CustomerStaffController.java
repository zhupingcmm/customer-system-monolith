package com.mf.projects.customer.system.controller.webmvc;

import com.mf.projects.cs.infrastructure.page.PageObject;
import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.customer.system.controller.vo.CustomerStaffVO;
import com.mf.projects.customer.system.converter.CustomerStaffConverter;
import com.mf.projects.customer.system.service.ICustomerStaffService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

@Slf4j
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

    @GetMapping("/async/{staffId}")
    public WebAsyncTask<CustomerStaffVO> asyncFindCustomerStaffById(@PathVariable("staffId") Long staffId) {
        log.info("The main thread name is %s", Thread.currentThread().getName());

        WebAsyncTask<CustomerStaffVO> task = new WebAsyncTask<>(5 * 1000, () -> {

            Thread.sleep(10000);
            val customerStaff = customerStaffService.findCustomerStaffById(staffId);
            return CustomerStaffConverter.INSTANCE.covertToVO(customerStaff);
        });
        task.onTimeout(() -> {
            log.info("Task timeout");
            return new CustomerStaffVO();
        });

        task.onError(() -> {
            log.info("Task on error");
            return new CustomerStaffVO();
        });

        task.onCompletion(() -> {
            log.info("Task on Completion");
        });

        log.info("Task is running!!!");
        return task;

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
