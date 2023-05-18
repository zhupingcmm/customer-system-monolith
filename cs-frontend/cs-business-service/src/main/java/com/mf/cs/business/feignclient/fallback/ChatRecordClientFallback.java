package com.mf.cs.business.feignclient.fallback;

import com.mf.cs.business.controller.vo.ChatRecordVO;
import com.mf.cs.business.feignclient.ChatRecordClient;
import com.mf.projects.cs.infrastructure.vo.Result;
import org.springframework.stereotype.Component;

@Component
public class ChatRecordClientFallback implements ChatRecordClient {
    @Override
    public Result<Boolean> insertChatRecord(ChatRecordVO chatRecordVO) {

        return Result.success(false);
    }
}
