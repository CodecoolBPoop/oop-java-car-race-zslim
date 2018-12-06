package com.codecool.car_race;

public class Weather {

    private boolean raining;

    public void setRaining() {
        raining = Util.prob(0.3);
    }

    public boolean isRaining() {
        return raining;
    }
}
