package com.ericadubois;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;


public class NumberGeneratorImp implements NumberGenerator{

    // --fields--
    private final Random random = new Random();

    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    @MinNumber
    private int minNumber;

    //--public methods--
    @Override
    public int next() {
        //ex. min = 5 max = 20 -> max -min = 15 -> range = 0-15 + min --> 5 -20
        return random.nextInt(maxNumber - minNumber) + minNumber;
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
