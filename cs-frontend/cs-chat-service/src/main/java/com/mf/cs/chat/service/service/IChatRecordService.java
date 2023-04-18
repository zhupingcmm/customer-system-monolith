package com.mf.cs.chat.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mf.cs.chat.service.domain.CustomerTicket;
import com.mf.cs.chat.service.entity.ChatRecord;

public interface IChatRecordService extends IService<ChatRecord> {
    void insertChat(ChatRecord chatRecord);

    void generateChatRecord(ChatRecord chatRecord);

    void doGenerateChatRecord(CustomerTicket customerTicket);
}
