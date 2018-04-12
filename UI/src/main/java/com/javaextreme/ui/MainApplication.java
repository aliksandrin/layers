package com.javaextreme.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/*-context.xml");
        logger.info("Spring context initialized.");


        if (args.length == 0) {
            logger.error("You didn't enter a date. Please try again later ;)");
            return;
        }

        UI ui = context.getBean(UI.class);
        ui.showDayOfWeek(args[0]);
    }
}
