package com.mf.projects.customer.system.servicebus.router.shanghai;

import com.mf.projects.customer.system.servicebus.router.OutsourcingRouter;
import com.mf.projects.customer.system.servicebus.router.shanghai.dto.ShanghaiCustomerStaff;
import org.springframework.stereotype.Component;

import java.util.List;
@Component(value = "shanghai_router")
public class ShanghaiOutsourcingSystemRouter implements OutsourcingRouter<ShanghaiCustomerStaff> {
    @Override
    public List<ShanghaiCustomerStaff> fetchOutsourcingStaffs(String systemUrl) {
        return null;
    }
}
