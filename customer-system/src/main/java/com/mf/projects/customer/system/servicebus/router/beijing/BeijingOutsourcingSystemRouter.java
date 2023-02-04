package com.mf.projects.customer.system.servicebus.router.beijing;

import com.mf.projects.customer.system.servicebus.router.OutsourcingRouter;
import com.mf.projects.customer.system.servicebus.router.beijing.dto.BeijingCustomerStaff;
import org.springframework.stereotype.Component;

import java.util.List;
@Component(value = "beijing_router")
public class BeijingOutsourcingSystemRouter implements OutsourcingRouter<BeijingCustomerStaff> {
    @Override
    public List<BeijingCustomerStaff> fetchOutsourcingStaffs(String systemUrl) {
        return null;
    }
}
