package com.mf.integration.service.provider.servicebus.endpoint.impl;


import com.mf.integration.service.api.dto.OutsourcingSystemDTO;
import com.mf.integration.service.provider.servicebus.common.CustomerStaff;
import com.mf.integration.service.provider.servicebus.endpoint.AbstractCustomerStaffEndpoint;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerStaffEndpointImpl extends AbstractCustomerStaffEndpoint<PlatformCustomerStaff> {

    @Override
    public List<PlatformCustomerStaff> fetchCustomerStaffs(Integer currentPage, Integer pageSize, OutsourcingSystemDTO outsourcingSystem) {
        // 获取外部系统路由
        val outsourcingSystemRouter = getRouter(outsourcingSystem);

        // 获取外部系统客服信息
        val originStaffs = outsourcingSystemRouter.fetchOutsourcingStaffs(currentPage, pageSize, outsourcingSystem.getSystemUrl());
        // 获取 数据转换器
        val transformer = getTransformer(outsourcingSystem);
        // 进行数据转换
        Long systemId = outsourcingSystem.getAppId();
        val customerStaffs = transformer.transformCustomerStaffs(systemId, originStaffs);
        //进行数据的过滤
        List<PlatformCustomerStaff> finalStaffs = new ArrayList<>();
        customerStaffs.forEach(staff -> {
            val finalStaff = getFilterChain().execute((PlatformCustomerStaff) staff);
            if (finalStaff != null) finalStaffs.add(finalStaff);
        });

        log.info("origin staff {} {}", originStaffs, finalStaffs);
        return finalStaffs;
    }

    @Override
    public Long getCustomerStaffCount(OutsourcingSystemDTO outsourcingSystem) {
        // 获取外部系统路由
        val outsourcingSystemRouter = getRouter(outsourcingSystem);

        return outsourcingSystemRouter.getCustomerStaffCount(outsourcingSystem.getSystemUrl());
    }

    @Override
    public PlatformCustomerStaff getPlatformCustomerStaff(OutsourcingSystemDTO outsourcingSystem, CustomerStaff customerStaff) {
        // 获取 数据转换器
        val transformer = getTransformer(outsourcingSystem);
        val platformCustomerStaff = transformer.transformCustomerStaff(outsourcingSystem.getAppId(), customerStaff);

        // 进行过滤
        return getFilterChain().execute(platformCustomerStaff);
    }

}
