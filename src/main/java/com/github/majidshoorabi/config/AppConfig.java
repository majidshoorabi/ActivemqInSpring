package com.github.majidshoorabi.config;

import com.github.majidshoorabi.receiver.MessageConsumer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
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
@EnableJms
public class AppConfig {

    public static final String queueName = "TestQueue";
    public static final String brokerUrl = "tcp://localhost:616106";

    @Bean
    public ConnectionFactory connectionFactory(){

        /**
         * You can set this url "vm://localhost" as brokerUrl if you don't have an activemq service for your test
         */
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(AppConfig.brokerUrl);
        return connectionFactory;
    }

    @Bean
    public MessageListenerContainer messageListenerContainer(){
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setMessageListener(new MessageConsumer());
        container.setDestinationName(AppConfig.queueName);
        container.setConcurrency("3-6");
        return container;
    }
}
