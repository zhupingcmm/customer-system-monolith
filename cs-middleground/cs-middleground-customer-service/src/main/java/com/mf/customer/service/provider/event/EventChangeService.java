package com.mf.customer.service.provider.event;

import event.DomainEvent;
import event.EventChange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventChangeService<T> implements EventChange<T> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String exchange, String rotingKey, DomainEvent<T> domainEvent) {

        rabbitTemplate.convertAndSend(exchange,rotingKey, domainEvent);
    }
}
