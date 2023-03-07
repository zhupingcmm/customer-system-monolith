package com.mf.ticket.service.listener;

import com.alibaba.fastjson.JSON;
import com.mf.ticket.service.entity.LocalCustomerStaff;
import com.mf.ticket.service.listener.dto.CustomerStaffEventDTO;
import com.mf.ticket.service.service.LocalCustomerStaffService;
import com.rabbitmq.client.Channel;
import event.DomainEvent;
import event.Operation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RabbitListener(queues = "customer.staff", ackMode = "MANUAL")
public class CustomerStaffListener {

    @Qualifier("redis_local_customer")
    @Autowired
    private LocalCustomerStaffService localCustomerStaffService;


    @RabbitHandler
    public void receivedMessageHandler(@Payload byte[] message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {

        val domainEvent = (DomainEvent<CustomerStaffEventDTO>)JSON.parseObject(message, DomainEvent.class);

        log.info("domain event: {}", domainEvent);

        try {
            val operation = domainEvent.getOperation();
            val eventMessage = JSON.parseObject(JSON.toJSONString(domainEvent.getMessage()), CustomerStaffEventDTO.class);
            val localCustomerStaff = getLocalCustomerStaff(eventMessage);

            if (operation.equals(Operation.ADD)) {
                localCustomerStaffService.insertLocalCustomerStaff(localCustomerStaff);
            } else if (operation.equals(Operation.UPDATE)) {
                localCustomerStaffService.updateLocalCustomerStaff(localCustomerStaff);
            } else if (operation.equals(Operation.DELETE)) {
                localCustomerStaffService.deleteLocalCustomerStaff(localCustomerStaff);
            }

            channel.basicAck(deliveryTag, false);
        }catch (Exception ex) {
            channel.basicNack(deliveryTag, false, true);
        }
    }

    private LocalCustomerStaff getLocalCustomerStaff(CustomerStaffEventDTO customerStaffEventDTO){
        LocalCustomerStaff localCustomerStaff = new LocalCustomerStaff();
        localCustomerStaff.setStaffId(customerStaffEventDTO.getId());
        localCustomerStaff.setStaffName(customerStaffEventDTO.getStaffName());
        localCustomerStaff.setAccountId(customerStaffEventDTO.getAccountId());
        localCustomerStaff.setPhone(customerStaffEventDTO.getPhone());
        return localCustomerStaff;
    }
}
