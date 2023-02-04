package com.mf.projects.customer.system.servicebus.transfomer;

import com.mf.projects.customer.system.entity.tenant.OutsourcingSystem;
import com.mf.projects.customer.system.servicebus.enums.OutSystem;
import com.mf.projects.customer.system.utils.SpringUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerStaffTransformerFactory {

    public CustomerStaffTransformer getTransformer(OutsourcingSystem outsourcingSystem){
        if (OutSystem.SHANGHAI.getId().equals(outsourcingSystem.getAppId())) {
            return SpringUtils.getBean(OutSystem.SHANGHAI.getTransformer());
        } else if (OutSystem.BEIJING.getId().equals(outsourcingSystem.getAppId())) {
            return SpringUtils.getBean(OutSystem.BEIJING.getTransformer());
        } else if (OutSystem.HANGZHOU.getId().equals(outsourcingSystem.getAppId())) {
            return SpringUtils.getBean(OutSystem.HANGZHOU.getTransformer());
        }
        return null;
    }

}
