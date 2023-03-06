package com.mf.ticket.service.listener;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import event.DomainEvent;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RabbitListener(queues = "customer.staff", ackMode = "MANUAL")
public class CustomerStaffListener {


    @RabbitHandler
    public void receivedMessageHandler(@Payload byte[] message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {

        val domainEvent = JSON.parseObject(message, DomainEvent.class);

        log.info("domain event: {}", domainEvent);

        try {
            channel.basicAck(deliveryTag, false);
        }catch (Exception ex) {
            channel.basicNack(deliveryTag, false, true);
        }


    }
}
