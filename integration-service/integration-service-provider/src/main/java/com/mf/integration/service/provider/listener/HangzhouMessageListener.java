package com.mf.integration.service.provider.listener;

import com.alibaba.fastjson.JSON;
import com.mf.integration.service.provider.intergration.CustomerServiceClient;
import com.mf.integration.service.provider.servicebus.endpoint.CustomerStaffEndpoint;
import com.mf.integration.service.provider.servicebus.enums.OutSystem;
import com.mf.integration.service.provider.servicebus.router.hangzhou.dto.HangzhouCustomerStaff;
import com.mf.projects.cs.infrastructure.domain.PlatformCustomerStaff;
import com.rabbitmq.client.Channel;
import domain.OutsourcingSystemDTO;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RabbitListener(queues = "hangzhou", ackMode = "MANUAL")
public class HangzhouMessageListener {

    @Autowired
    private CustomerServiceClient customerServiceClient;

    @Autowired
    private CustomerStaffEndpoint<PlatformCustomerStaff> customerStaffEndpoint;

    @RabbitHandler
    public void receivedMessageHandler(@Payload byte[] message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        val hangzhouStaff = (HangzhouCustomerStaff) JSON.parseObject(message, HangzhouCustomerStaff.class);
        log.info("received hangzhou staff : {}", hangzhouStaff);
        try {
            OutsourcingSystemDTO outsourcingSystemDTO = new OutsourcingSystemDTO();
            outsourcingSystemDTO.setAppId(OutSystem.HANGZHOU.getId());
            outsourcingSystemDTO.setSystemName("hangzhou");

            val platformCustomerStaff = customerStaffEndpoint.getPlatformCustomerStaff(outsourcingSystemDTO,  hangzhouStaff);
            customerServiceClient.updateCustomerStaff(platformCustomerStaff);
            channel.basicAck(deliveryTag, false);
        } catch (Exception ex) {
            log.info("failed consumer the message {}, and return the dead letter queue!", hangzhouStaff);
            channel.basicNack(deliveryTag, false, true);
        }
    }
}
