package com.github.majidshoorabi;


import com.github.majidshoorabi.config.AppConfig;
import com.github.majidshoorabi.sender.MessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author majid.shoorabi
 * @created 2022-02-June
 * @project IntelliJ IDEA
 */

public class JmsActiveMQApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        String queueName = "TestQueue";

        MessageSender sender = context.getBean(MessageSender.class);
        sender.sendMessage(queueName,"This is a test message");




    }
}
