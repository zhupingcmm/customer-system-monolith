package com.mf.cs.gateway.controller;

import com.mf.cs.gateway.service.ApmService;
import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/record")
public class ApmController {

    @Autowired
    private ApmService apmService;

    @GetMapping("/{currentpage}/{pagesize}")
    public Result<?> getRecords(@PathVariable("currentpage") long currentPage, @PathVariable("pagesize") long pageSize) {
        return Result.success(apmService.getRecords(pageSize, currentPage));
    }
}
