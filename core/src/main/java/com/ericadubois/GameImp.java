package com.ericadubois;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GameImp implements Game{

    // == constants==
    private static final Logger log = LoggerFactory.getLogger(GameImp.class);

    // == fields==

    @Autowired
    private NumberGenerator numberGenerator;

    //how many times the player can guess the number before the game is over
    private int guessCount = 10;
    //holds value of randomly generated number for player to guess
    private int number;
    //player's guess
    private int guess;
    //range in which the player should guess ex. 0-100
    private int smallest;
    private int biggest;
    //number of remaining guesses
    private int remainingGuesses;
    //
    private boolean validNumberRange = true;

    //== constructors ==
    //commented out to use setter base dep. injection instead
   /* public GameImp(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }*/

    // == init-method ==
    //called at intial start of game and then at end of game to reset values
    @PostConstruct
    @Override
    public void reset() {
        smallest = 0;
        guess = 0;
        remainingGuesses= guessCount;
        biggest= numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("number is {}", number);
    }
    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy()");
    }
    // ==public methods==

   /* No longer needed with autowiring
   public void setNumberGenerator(NumberGenerator numberGenerator){
        this.numberGenerator = numberGenerator;
    }*/

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
     this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if(validNumberRange){
            if(guess > number){
                biggest = guess - 1;
            }
            if (guess < number){
                smallest = guess + 1;
            }
        }
        remainingGuesses --;
    }

    @Override
    public boolean isValidNumberRange(){
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
     private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
        }
}
