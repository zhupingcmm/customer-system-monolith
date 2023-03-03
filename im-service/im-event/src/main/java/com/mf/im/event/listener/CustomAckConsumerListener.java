package com.mf.im.event.listener;

import com.alibaba.fastjson.JSON;
import com.mf.projects.im.dto.P2PChatRequest;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomAckConsumerListener implements ChannelAwareMessageListener {



    @RabbitHandler
    public void receivedMessageHandler() {

    }

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        val messageProperties = message.getMessageProperties();
        long deliveryTag = messageProperties.getDeliveryTag();
        val exchange = messageProperties.getReceivedExchange();
        val routingKey = messageProperties.getReceivedRoutingKey();
        val queue = messageProperties.getConsumerQueue();
        val body = message.getBody();
        val request = JSON.parseObject(body, P2PChatRequest.class);

        try {


            log.info("message {} from exchange: {} use routingKey: {} with queue: {}", request, exchange, routingKey, queue);
            /**
             * 签收消息
             * deliveryTag： 投递标签
             *  multiple: 是否批量签收
             */
            channel.basicAck(deliveryTag, false);
        } catch (Exception ex) {
            log.error("Message: {} will back to the queue", request);
            /**
             * deliveryTag: 投递标签
             *  multiple: 是否批量签收
             * re queue，是否重回队列，如果不回队列，消息真的就应该让它消失吗？？？
             */
            channel.basicNack(deliveryTag, false, true);
        }
    }
}
