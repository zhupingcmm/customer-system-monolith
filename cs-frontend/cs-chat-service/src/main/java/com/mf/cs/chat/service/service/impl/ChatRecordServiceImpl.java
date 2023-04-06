package com.mf.cs.chat.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mf.cs.chat.service.entity.ChatRecord;
import com.mf.cs.chat.service.mapper.ChatRecordMapper;
import com.mf.cs.chat.service.service.IChatRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatRecordServiceImpl extends ServiceImpl<ChatRecordMapper, ChatRecord> implements IChatRecordService {

    @Override
    @Transactional
    public void insertChat(ChatRecord chatRecord) {
        this.save(chatRecord);
    }
}
