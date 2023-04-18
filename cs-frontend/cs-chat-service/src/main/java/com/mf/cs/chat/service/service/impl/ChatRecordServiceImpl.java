package com.mf.cs.chat.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mf.cs.chat.service.domain.CustomerTicket;
import com.mf.cs.chat.service.entity.ChatRecord;
import com.mf.cs.chat.service.mapper.ChatRecordMapper;
import com.mf.cs.chat.service.service.IChatRecordService;
import lombok.val;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatRecordServiceImpl extends ServiceImpl<ChatRecordMapper, ChatRecord> implements IChatRecordService {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Override
    @Transactional
    public void insertChat(ChatRecord chatRecord) {
        this.save(chatRecord);
    }

    @Override
    public void generateChatRecord(ChatRecord chatRecord) {
        // 将消息发送到 rabbit MQ
        rabbitTemplate.convertAndSend("chat.exchange", "chat.routing.key", createCustomerTicket(chatRecord));
    }

    @Override
    public void doGenerateChatRecord(CustomerTicket customerTicket) {
        val chatRecord = createChatRecord(customerTicket);
        save(chatRecord);

    }

    public ChatRecord createChatRecord(CustomerTicket customerTicket) {
        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setStaffId(customerTicket.getStaffId());
        chatRecord.setTicketNo(customerTicket.getTicketNo());
        chatRecord.setUserId(chatRecord.getUserId());
        chatRecord.setLastMessage("test");

        return chatRecord;
    }

    public CustomerTicket createCustomerTicket(ChatRecord chatRecord){
       return CustomerTicket.builder()
               .inquire("test")
               .staffId(chatRecord.getStaffId())
               .userId(chatRecord.getUserId())
               .status(1)
               .score(10)
                .build();

    }
}
