package com.mf.projects.customer.system.servicebus.router;

import java.util.List;

public interface OutsourcingRouter<T> {

    List<T> fetchOutsourcingStaffs(String systemUrl);

}
