package com.codecool.car_race;

public class Util {

    public static boolean prob(double percentage) {
        boolean result = Math.random() >= 1.0 - percentage;
        return result;
    }

    public static int getRandomInt(int min, int max) {
        int rand = (int) Math.round(Math.random() * (max - min)) + min;
        return rand;
    }
}
