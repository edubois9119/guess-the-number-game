package com.ericadubois;


import com.ericadubois.console.AppConfig;
import com.ericadubois.console.MessageGenerator;
import com.ericadubois.console.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get NumberGenerator bean from context(container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        //call method next() to get a random number
        int number = numberGenerator.next();

        //log generated number
        log.info("number = {}", number);

        // get Game bean from context(container)
       /* Game game = context.getBean(Game.class);*/

        // get Message Generator bean from context(container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        log.info("getMainMessagae= {}", messageGenerator.getMainMessage());
        log.info("getResultMessagae= {}", messageGenerator.getResultMessage());

        //removing this method call from main class, will be called by container instead
       /* //call reset method
        game.reset();*/

        //close context (container) prevent memory resource leaks
        context.close();

    }
}
