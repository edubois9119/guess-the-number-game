package com.ericadubois;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;


public class NumberGeneratorImpl implements NumberGenerator{

    // --fields--
    private final Random random = new Random();

    @Autowired
    @MaxNumber
    // no longer instantiated since its autowired, should get number from Game Config class
    private int maxNumber;

    @Autowired
    @MinNumber
    // no longer instantiated since its autowired, should get number from Game Config class
    private int minNumber;


    //--public methods--
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
