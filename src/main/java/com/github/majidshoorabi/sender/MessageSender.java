package com.github.majidshoorabi.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author majid.shoorabi
 * @created 2022-02-June
 * @project JmsActivemq
 */

@Component
public class MessageSender {

    @Autowired
    private ConnectionFactory connectionFactory;

    private JmsTemplate jmsTemplate;

    @PostConstruct
    public void init(){
        this.jmsTemplate = new JmsTemplate(this.connectionFactory);
    }


    public void sendMessage(String queueName, String message){
        this.jmsTemplate.send(queueName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

}
