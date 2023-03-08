package com.mf.customer.service.provider.controller.webmvc;


import com.mf.customer.service.provider.controller.vo.OutsourcingSystemVO;
import com.mf.customer.service.provider.converter.OutsourcingSystemConverter;
import com.mf.customer.service.provider.service.IOutsourcingSystemService;
import com.mf.projects.cs.infrastructure.vo.Result;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oursouringsystem")
public class OutsourcingSystemController {
    @Autowired
    private IOutsourcingSystemService outsourcingSystemService;

    @PostMapping
    public Result<Boolean> addOutsourcingSystem(@RequestBody OutsourcingSystemVO outsourcingSystemVO){
        val outsourcingSystem = OutsourcingSystemConverter.INSTANCE.convertToEntity(outsourcingSystemVO);
        outsourcingSystemService.addOutsourcingSystem(outsourcingSystem);
        return Result.success(true);
    }

    @GetMapping("/{systemid}")
    public Result<OutsourcingSystemVO> findOutsourcingSystemById(@PathVariable("systemid") Long systemId){
        val customerStaffVO = OutsourcingSystemConverter.INSTANCE.convertToVO(outsourcingSystemService.findOutsourcingSystemById(systemId));
        return Result.success(customerStaffVO);
    }


    @DeleteMapping("{systemid}")
    public Result<Boolean> deleteBySystemId(@PathVariable("systemid") Long systemId){
        outsourcingSystemService.deleteBySystemId(systemId);
        return Result.success(true);
    }
}
