package com.ericadubois;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("generator")
public class NumberGeneratorImp implements NumberGenerator{

    // --fields--
    private final Random random = new Random();
    private int maxNumber = 100;

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
