package com.mf.im.event.config;

import com.mf.im.event.listener.CustomAckConsumerListener;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MessageListenerAdapter messageListenerAdapter(CustomAckConsumerListener customAckConsumerListener){
        return new MessageListenerAdapter(customAckConsumerListener);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(MessageListenerAdapter messageListenerAdapter, ConnectionFactory connectionFactory) {
        messageListenerAdapter.setMessageConverter(jsonMessageConverter());
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setMessageListener(messageListenerAdapter);
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("im_messages");
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setPrefetchCount(1);
        return container;
    }
}
