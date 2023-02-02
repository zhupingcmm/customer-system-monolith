package com.mf.projects.customer.system.controller.webmvc;

import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.customer.system.controller.vo.OutsourcingSystemVO;
import com.mf.projects.customer.system.converter.OutsourcingSystemConverter;
import com.mf.projects.customer.system.service.IOutsourcingSystemService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oursouringsystem")
public class OutsourcingSystemController {
    @Autowired
    private IOutsourcingSystemService outsourcingSystemService;

    @PostMapping
    public Result addOutsourcingSystem(@RequestBody OutsourcingSystemVO outsourcingSystemVO){
        val outsourcingSystem = OutsourcingSystemConverter.INSTANCE.convertToEntity(outsourcingSystemVO);
        outsourcingSystemService.addOutsourcingSystem(outsourcingSystem);
        return Result.success();
    }

    @GetMapping("/{systemid}")
    public Result<OutsourcingSystemVO> findOutsourcingSystemById(@PathVariable("systemid") Long systemId){
        val customerStaffVO = OutsourcingSystemConverter.INSTANCE.convertToVO(outsourcingSystemService.findOutsourcingSystemById(systemId));
        return Result.success(customerStaffVO);
    }
}
