package com.github.majidshoorabi.receiver;

import com.github.majidshoorabi.config.AppConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * @author majid.shoorabi
 * @created 2022-02-June
 * @project IntelliJ IDEA
 */

@Component
public class MessageConsumer {

    @JmsListener(destination = AppConfig.queueName)
    public void listenMessage(String msg){
        System.out.println("***** Text is :" + msg);
    }
}
