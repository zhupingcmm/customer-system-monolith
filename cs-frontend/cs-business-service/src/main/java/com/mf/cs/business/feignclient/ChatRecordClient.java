package com.mf.cs.business.feignclient;

import com.mf.cs.business.controller.vo.ChatRecordVO;
import com.mf.cs.business.feignclient.fallback.ChatRecordClientFallback;
import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "chat-service", path = "/chatrecord", fallback = ChatRecordClientFallback.class)
public interface ChatRecordClient {

    @PostMapping
    Result<Boolean> insertChatRecord(@RequestBody ChatRecordVO chatRecordVO);
}
