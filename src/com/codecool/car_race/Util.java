package com.codecool.car_race;

public class Util {

    public static boolean prob(double percentage) {
        boolean result = Math.random() >= 1.0 - percentage;
        return result;
    }

    public static int getRandomNumber(int min, int max) {
        if (max < min) {
            int y = max;
            max = min;
            min = y;
        }
        int rand = round(Math.random() * (max - min)) + min;
        return rand;
    }

    public static double getRandomNumber(double min, double max) {
        if (max < min) {
            double y = max;
            max = min;
            min = y;
        }
        double rand = Math.random() * (max - min) + min;
        return rand;
    }

    public static int round(double number) {
        return (int) Math.round(number);
    }
    public static int round(float number) {
        return (int) Math.round(number);
    }
}
