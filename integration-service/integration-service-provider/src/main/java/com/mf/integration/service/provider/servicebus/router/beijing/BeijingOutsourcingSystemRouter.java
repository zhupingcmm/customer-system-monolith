package com.mf.integration.service.provider.servicebus.router.beijing;


import com.mf.integration.service.provider.servicebus.router.OutsourcingRouter;
import com.mf.integration.service.provider.servicebus.router.beijing.dto.BeijingCustomerStaff;
import org.springframework.stereotype.Component;

import java.util.List;
@Component(value = "beijing_router")
public class BeijingOutsourcingSystemRouter implements OutsourcingRouter<BeijingCustomerStaff> {
    @Override
    public List<BeijingCustomerStaff> fetchOutsourcingStaffs(String systemUrl) {
        return null;
    }
}
