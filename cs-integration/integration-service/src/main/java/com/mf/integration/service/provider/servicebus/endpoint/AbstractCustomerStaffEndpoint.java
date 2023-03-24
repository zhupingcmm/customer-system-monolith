package com.mf.integration.service.provider.servicebus.endpoint;

import com.mf.integration.service.api.dto.OutsourcingSystemDTO;
import com.mf.integration.service.provider.servicebus.enums.OutSystem;
import com.mf.integration.service.provider.servicebus.filter.CustomerStaffFilterChain;
import com.mf.integration.service.provider.servicebus.filter.impl.CustomerStaffEmptyFilter;
import com.mf.integration.service.provider.servicebus.filter.impl.CustomerStaffSpecialCharactersFilter;
import com.mf.integration.service.provider.servicebus.router.OutsourcingRouter;
import com.mf.integration.service.provider.servicebus.transfomer.CustomerStaffTransformer;
import com.mf.integration.service.provider.utils.SpringUtils;

import java.util.Objects;

public abstract class AbstractCustomerStaffEndpoint<T> implements CustomerStaffEndpoint<T>{
    protected CustomerStaffFilterChain getFilterChain() {
        CustomerStaffFilterChain customerStaffFilterChain = new CustomerStaffFilterChain();
        customerStaffFilterChain.addFilter(new CustomerStaffEmptyFilter());
        customerStaffFilterChain.addFilter(new CustomerStaffSpecialCharactersFilter());
        return customerStaffFilterChain;

    }
    protected  <V> OutsourcingRouter<V> getRouter (OutsourcingSystemDTO outsourcingSystem){
        Long appId = outsourcingSystem.getAppId();
        OutsourcingRouter<V> router;
        if (Objects.equals(appId, OutSystem.SHANGHAI.getId())) {
            router = SpringUtils.getBean(OutSystem.SHANGHAI.getRouter());
        } else if (Objects.equals(appId, OutSystem.BEIJING.getId())) {
            router = SpringUtils.getBean(OutSystem.BEIJING.getRouter());
        } else {
            router =  SpringUtils.getBean(OutSystem.HANGZHOU.getRouter());
        }
        return router;
    }

    protected  <V> CustomerStaffTransformer<V> getTransformer(OutsourcingSystemDTO outsourcingSystem){
        Long appId = outsourcingSystem.getAppId();
        CustomerStaffTransformer<V> transformer;
        if (Objects.equals(appId, OutSystem.SHANGHAI.getId())) {
            transformer = SpringUtils.getBean(OutSystem.SHANGHAI.getTransformer());
        } else if (Objects.equals(appId, OutSystem.BEIJING.getId())) {
            transformer = SpringUtils.getBean(OutSystem.BEIJING.getTransformer());
        } else {
            transformer = SpringUtils.getBean(OutSystem.HANGZHOU.getTransformer());
        }
        return transformer;
    }

}
