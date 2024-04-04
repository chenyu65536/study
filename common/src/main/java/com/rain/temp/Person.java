package com.rain.temp;

import java.util.Random;

public class Person {

    @Override
    public int hashCode() {
        Random random  = new Random();
        return random.nextInt(1000);
    }
}
