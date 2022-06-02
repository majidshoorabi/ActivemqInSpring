package com.github.majidshoorabi.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author majid.shoorabi
 * @created 2022-02-June
 * @project IntelliJ IDEA
 */

public class MessageConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;
        try {

            Thread.sleep(500);
            System.out.println("***** Text is :" + textMessage.getText());

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
