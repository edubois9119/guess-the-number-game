package com.ericadubois;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //create context (container)
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // get NumberGenerator bean from context(container)
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        //call method next() to get a random number
        int number = numberGenerator.next();

        //log generated number
        log.info("number = {}", number);

        // get Game bean from context(container)
        Game game = context.getBean(Game.class);

        //call reset method
        game.reset();

        //close context (container) prevent memory resource leaks
        context.close();

    }
}
