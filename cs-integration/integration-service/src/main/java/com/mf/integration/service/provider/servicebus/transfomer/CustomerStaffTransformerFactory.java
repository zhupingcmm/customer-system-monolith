package com.mf.integration.service.provider.servicebus.transfomer;

import com.mf.integration.service.api.dto.OutsourcingSystemDTO;
import com.mf.integration.service.provider.servicebus.enums.OutSystem;
import com.mf.integration.service.provider.utils.SpringUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerStaffTransformerFactory{

    public CustomerStaffTransformer getTransformer(OutsourcingSystemDTO outsourcingSystem){
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
