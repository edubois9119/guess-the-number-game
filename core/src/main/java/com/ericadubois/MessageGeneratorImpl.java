package com.ericadubois;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    //== constants ==
    public static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);


    //== fields ==
    @Autowired
    private Game game;

    //== init method ==
    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }
    //== public methods ==

    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + "and " + game.getBiggest() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "You guess it! The number was " + game.getNumber();
        }else if(game.isGameLost()){
            return "Game Over, you lost... The number was " + game.getNumber();
        }else if(!game.isValidNumberRange()){
            return "Sorry, the number you guessed is not in the valid number range";
        } else if (game.getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess?";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + "guess(es) left";
        }
    }
}
