package com.ericadubois;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;


public class NumberGeneratorImpl implements NumberGenerator{

    // --fields--
    private final Random random = new Random();

    @Autowired
    // no longer instantiated since its autowired, should get number from Game Config class
    private int maxNumber;

    //--public methods--
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}