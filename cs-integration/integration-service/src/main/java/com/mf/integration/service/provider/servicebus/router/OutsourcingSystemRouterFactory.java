package com.mf.integration.service.provider.servicebus.router;

import com.mf.integration.service.api.dto.OutsourcingSystemDTO;
import com.mf.integration.service.provider.servicebus.enums.OutSystem;
import com.mf.integration.service.provider.utils.SpringUtils;
import org.springframework.stereotype.Component;


@Component
public class OutsourcingSystemRouterFactory {

    public OutsourcingRouter getOutsourcingSystemRouter(OutsourcingSystemDTO outsourcingSystem){
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
