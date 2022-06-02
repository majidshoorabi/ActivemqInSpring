package com.github.majidshoorabi;


import com.github.majidshoorabi.config.AppConfig;
import com.github.majidshoorabi.receiver.MessageReceiver;
import com.github.majidshoorabi.sender.MessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author majid.shoorabi
 * @created 2022-02-June
 * @project IntelliJ IDEA
 */

public class JmsActiveMQApplication {

    private static final String queueName = "TestQueue";

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender sender = context.getBean(MessageSender.class);
        sender.sendMessage(JmsActiveMQApplication.queueName,"This is a test message");

        MessageReceiver receiver =context.getBean(MessageReceiver.class);
        receiver.receiveMessage(JmsActiveMQApplication.queueName);

    }
}
