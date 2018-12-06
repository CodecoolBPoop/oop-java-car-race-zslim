package com.codecool.car_race;

public class Util {

    public boolean prob(float percentage) {
        boolean result = Math.random() >= 1.0 - percentage;
        return result;
    }
}
