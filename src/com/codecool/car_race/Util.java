package com.codecool.car_race;

public class Util {

    static public boolean prob(double percentage) {
        boolean result = Math.random() >= 1.0 - percentage;
        return result;
    }
}
