package com.github.majidshoorabi.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author majid.shoorabi
 * @created 2022-02-June
 * @project JmsActivemq
 */

@Component
public class MessageReceiver {

    @Autowired
    private ConnectionFactory connectionFactory;
    private JmsTemplate jmsTemplate;

    @PostConstruct
    public void init() {
        this.jmsTemplate = new JmsTemplate(this.connectionFactory);
    }


    public void receiveMessage(String queueName) {
        Message message = this.jmsTemplate.receive(queueName);
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("***** Text is :" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
