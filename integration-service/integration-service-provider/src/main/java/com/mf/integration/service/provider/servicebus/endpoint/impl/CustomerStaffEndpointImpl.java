package com.mf.integration.service.provider.servicebus.endpoint.impl;


import com.mf.integration.service.provider.servicebus.endpoint.CustomerStaffEndpoint;
import com.mf.integration.service.provider.servicebus.filter.CustomerStaffFilterChain;
import com.mf.integration.service.provider.servicebus.filter.impl.CustomerStaffEmptyFilter;
import com.mf.integration.service.provider.servicebus.filter.impl.CustomerStaffSpecialCharactersFilter;
import com.mf.integration.service.provider.servicebus.router.OutsourcingSystemRouterFactory;
import com.mf.integration.service.provider.servicebus.transfomer.CustomerStaffTransformerFactory;
import domain.OutsourcingSystemDTO;
import domain.PlatformCustomerStaff;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerStaffEndpointImpl implements CustomerStaffEndpoint<PlatformCustomerStaff> {

    @Autowired
    private OutsourcingSystemRouterFactory outsourcingSystemRouterFactory;

    @Autowired
    private CustomerStaffTransformerFactory customerStaffTransformerFactory;
    private CustomerStaffFilterChain customerStaffFilterChain;

    public CustomerStaffEndpointImpl() {
        customerStaffFilterChain = new CustomerStaffFilterChain();
        customerStaffFilterChain.addFilter(new CustomerStaffEmptyFilter());
        customerStaffFilterChain.addFilter(new CustomerStaffSpecialCharactersFilter());
    }

    @Override
    public List<PlatformCustomerStaff> fetchCustomerStaffs(OutsourcingSystemDTO outsourcingSystem) {
        // 获取外部系统路由
        val outsourcingSystemRouter = outsourcingSystemRouterFactory.getOutsourcingSystemRouter(outsourcingSystem);

        // 获取外部系统客服信息
        val originStaffs = outsourcingSystemRouter.fetchOutsourcingStaffs(outsourcingSystem.getSystemUrl());

        // 获取 数据转换器
        val transformer = customerStaffTransformerFactory.getTransformer(outsourcingSystem);
        // 进行数据转换
        Long systemId = outsourcingSystem.getAppId();
        val customerStaffs = transformer.transformCustomerStaffs(systemId, originStaffs);

        //进行数据的过滤
        List<PlatformCustomerStaff> finalStaffs = new ArrayList<>();
        customerStaffs.forEach(staff -> {
            val finalStaff = customerStaffFilterChain.execute((PlatformCustomerStaff) staff);
            if (finalStaff != null) finalStaffs.add(finalStaff);
        });

        log.info("origin staff {} {}", originStaffs, finalStaffs);
        return finalStaffs;
    }

}
