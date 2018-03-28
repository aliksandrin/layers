package com.javaextreme.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        logger.info("Spring context initialized.");

        StringReceiverUI stringReceiver = context.getBean(StringReceiverUI.class);
        stringReceiver.receive(args);
    }
}
