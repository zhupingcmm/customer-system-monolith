package com.mf.integration.service.provider.servicebus.router;

import java.util.List;

public interface OutsourcingRouter<T> {

    List<T> fetchOutsourcingStaffs(String systemUrl);

}
