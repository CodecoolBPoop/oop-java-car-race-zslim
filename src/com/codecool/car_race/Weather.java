package com.codecool.car_race;

public class Weather {

    private static final double RAIN_PROBABILITY = 0.3;

    private boolean raining;

    public Weather() {
        setRaining();
    }

    public void setRaining() {
        raining = Util.prob(RAIN_PROBABILITY);
    }

    public boolean isRaining() {
        return raining;
    }
}
