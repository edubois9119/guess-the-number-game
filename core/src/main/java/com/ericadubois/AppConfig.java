package com.ericadubois;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ericadubois")
public class AppConfig {

    //== bean methods==
    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImp();
    }

    @Bean
    public Game game() {
        return new GameImp();
    }

}