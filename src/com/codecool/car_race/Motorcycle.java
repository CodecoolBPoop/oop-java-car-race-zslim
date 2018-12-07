package com.codecool.car_race;

public class Motorcycle extends Vehicle {

    private static final int SPEED = 100;
    private static final int RAIN_DISADVANTAGE_MIN = 5;
    private static final int RAIN_DISADVANTAGE_MAX = 50;

    public Motorcycle(int number) {
        setName(number);
        setVehicleType();
    }

    @Override
    protected void setName() {
        // TODO: I need parameters in this class only, so is it okay to overload this method with one with parameters?
    }

    protected void setName(int number) {
        name = "Motorcycle " + number;
    }

    @Override
    public void prepareForLap(Race race) {
        if (race.weather.isRaining()) {
            currentSpeed = SPEED - Util.getRandomNumber(RAIN_DISADVANTAGE_MIN, RAIN_DISADVANTAGE_MAX);
        } else {
            currentSpeed = SPEED;
        }
    }
}
