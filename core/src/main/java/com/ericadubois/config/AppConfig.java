package com.ericadubois.config;

import com.ericadubois.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
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

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImp();
    }

}
