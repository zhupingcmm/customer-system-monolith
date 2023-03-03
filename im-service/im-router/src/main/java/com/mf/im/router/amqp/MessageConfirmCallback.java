package com.mf.im.router.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageConfirmCallback implements RabbitTemplate.ConfirmCallback
        ,RabbitTemplate.ReturnsCallback {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        //设置确认的回调方法
        rabbitTemplate.setConfirmCallback(this::confirm);
        //设置发送消息的回退方法
        rabbitTemplate.setReturnsCallback(this::returnedMessage);
    }
    /**
     * 消息发送到 exchange 的回调方法
     * @param correlationData
     * @param ack 是否确认消息到达 exchange
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.debug("message success in exchange {}", correlationData);
        } else {
            log.error("message failed in exchange {}", correlationData);
        }
    }

    /**
     * 消息从 exchange 到绑定的queue中失败后会回调这个方法
     * @param returnedMessage
     */
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.error("returnedMessage: {}", returnedMessage);
    }

}
