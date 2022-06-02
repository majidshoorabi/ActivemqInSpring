package com.github.majidshoorabi.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

/**
 * @author majid.shoorabi
 * @created 2022-02-June
 * @project JmsActivemq
 */

@Configuration
@ComponentScan("com.github.majidshoorabi")
public class AppConfig {

    private static final String brokerUrl = "tcp://localhost:61616";

    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(AppConfig.brokerUrl);
        return connectionFactory;
    }
}
