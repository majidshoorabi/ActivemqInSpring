package com.github.majidshoorabi.config;

import com.github.majidshoorabi.receiver.MessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import javax.jms.ConnectionFactory;

/**
 * @author majid.shoorabi
 * @created 2022-02-June
 * @project JmsActivemq
 */

@Configuration
@ComponentScan("com.github.majidshoorabi")
public class AppConfig {

    private static final String queueName = "TestQueue";

    @Bean
    public ConnectionFactory connectionFactory(){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        return connectionFactory;
    }

    @Bean
    public MessageListenerContainer messageListenerContainer(){
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setMessageListener(new MessageListener());
        container.setDestinationName(queueName);
        return container;
    }
}
