package com.sz.sip.services;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

public class StartClass {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MessageChannel inputChanel = context.getBean("inputChanel", MessageChannel.class);
        PollableChannel outputChanel = context.getBean("outputChanel", PollableChannel.class);
        inputChanel.send(new GenericMessage<String>("Hello everybody"));
        System.out.println(outputChanel.receive().getPayload());
    }
}
