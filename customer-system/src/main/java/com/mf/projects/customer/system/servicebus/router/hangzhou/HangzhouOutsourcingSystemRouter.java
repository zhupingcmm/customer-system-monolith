package com.mf.projects.customer.system.servicebus.router.hangzhou;

import com.mf.projects.cs.infrastructure.vo.Result;
import com.mf.projects.customer.system.servicebus.router.OutsourcingRouter;
import com.mf.projects.customer.system.servicebus.router.hangzhou.dto.HangzhouCustomerStaff;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component(value = "hangzhou_router")
public class HangzhouOutsourcingSystemRouter implements OutsourcingRouter<HangzhouCustomerStaff> {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<HangzhouCustomerStaff> fetchOutsourcingStaffs(String systemUrl) {
        val response = restTemplate.exchange(
                systemUrl,
                HttpMethod.GET,
                null,
                Result.class
        );

        return (List<HangzhouCustomerStaff>) response.getBody().getData();
    }
}
