package com.mf.cs.chat.service.amqp;

import com.alibaba.fastjson.JSON;
import com.mf.cs.chat.service.domain.CustomerTicket;
import com.mf.cs.chat.service.service.IChatRecordService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Slf4j
@Component
public class MessageConfirmCallback implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    IChatRecordService chatRecordService;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this::confirm);
        rabbitTemplate.setReturnsCallback(this::returnedMessage);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.debug("message [{}] success send to exchange", correlationData);
            val body = Objects.requireNonNull(correlationData.getReturned()).getMessage().getBody();
            val msgString = new String(body);
            val customerTicket = JSON.parseObject(msgString, CustomerTicket.class);
            chatRecordService.doGenerateChatRecord(customerTicket);
        } else {
            log.error("message [{}] failed send to exchange, with cause {}  ", correlationData, cause);
        }

    }

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.error("message [{}] failed send to queue", returnedMessage);
    }
}
