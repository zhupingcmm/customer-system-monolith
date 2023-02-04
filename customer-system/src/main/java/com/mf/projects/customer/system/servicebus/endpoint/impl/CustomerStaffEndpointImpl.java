package com.mf.projects.customer.system.servicebus.endpoint.impl;

import com.mf.projects.customer.system.entity.staff.CustomerStaff;
import com.mf.projects.customer.system.entity.tenant.OutsourcingSystem;
import com.mf.projects.customer.system.servicebus.endpoint.CustomerStaffEndpoint;
import com.mf.projects.customer.system.servicebus.filter.CustomerStaffFilterChain;
import com.mf.projects.customer.system.servicebus.filter.impl.CustomerStaffEmptyFilter;
import com.mf.projects.customer.system.servicebus.router.OutsourcingSystemRouterFactory;
import com.mf.projects.customer.system.servicebus.transfomer.CustomerStaffTransformerFactory;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerStaffEndpointImpl implements CustomerStaffEndpoint {

    @Autowired
    private OutsourcingSystemRouterFactory outsourcingSystemRouterFactory;

    @Autowired
    private CustomerStaffTransformerFactory customerStaffTransformerFactory;
    private CustomerStaffFilterChain customerStaffFilterChain;

    public CustomerStaffEndpointImpl() {
        customerStaffFilterChain = new CustomerStaffFilterChain();
        customerStaffFilterChain.addFilter(new CustomerStaffEmptyFilter());
    }

    @Override
    public List<CustomerStaff> fetchCustomerStaffs(OutsourcingSystem outsourcingSystem) {
        // 获取 路由
        val outsourcingSystemRouter = outsourcingSystemRouterFactory.getOutsourcingSystemRouter(outsourcingSystem);

        // 获取外部系统客服信息
        val originStaffs = outsourcingSystemRouter.fetchOutsourcingStaffs(outsourcingSystem.getSystemUrl());

        //进行数据转换
        val transformer = customerStaffTransformerFactory.getTransformer(outsourcingSystem);
        val customerStaffs = transformer.transformCustomerStaffs(originStaffs);

        //进行数据的过滤
        List<CustomerStaff> finalStaffs = new ArrayList<>();

        customerStaffs.forEach(staff -> {
            val finalStaff = customerStaffFilterChain.execute((CustomerStaff) staff);
            if (finalStaff != null) finalStaffs.add(finalStaff);
        });

        log.info("origin staff {} {}", originStaffs, finalStaffs);
        return finalStaffs;
    }
}
