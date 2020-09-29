package com.ericadubois.config;

import com.ericadubois.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//importing other config classes allows for modular configuration and the ability to load bean defs from multiple configs
@Import(GameConfig.class)
@ComponentScan(basePackages = "com.ericadubois")
public class AppConfig {

    //== bean methods==
    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }

}
