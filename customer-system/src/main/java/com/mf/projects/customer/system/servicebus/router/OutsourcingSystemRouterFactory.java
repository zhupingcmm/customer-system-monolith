package com.mf.projects.customer.system.servicebus.router;

import com.mf.projects.customer.system.entity.tenant.OutsourcingSystem;
import com.mf.projects.customer.system.servicebus.enums.OutSystem;
import com.mf.projects.customer.system.utils.SpringUtils;
import org.springframework.stereotype.Component;


@Component
public class OutsourcingSystemRouterFactory {

    public OutsourcingRouter getOutsourcingSystemRouter(OutsourcingSystem outsourcingSystem){
        if (OutSystem.SHANGHAI.getId().equals(outsourcingSystem.getAppId())) {
            return SpringUtils.getBean(OutSystem.SHANGHAI.getRouter());
        } else if (OutSystem.BEIJING.getId().equals(outsourcingSystem.getAppId())) {
            return SpringUtils.getBean(OutSystem.BEIJING.getRouter());
        } else if (OutSystem.HANGZHOU.getId().equals(outsourcingSystem.getAppId())) {
            return SpringUtils.getBean(OutSystem.HANGZHOU.getRouter());
        }
        return null;
    }
}
