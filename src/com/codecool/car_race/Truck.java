package com.codecool.car_race;

public class Truck extends Vehicle {

    private int breakdownTurnsLeft;

    private static final int SPEED = 100;
    private static final int BREAKDOWN_TURNS = 2;
    private static final double BREAKING_DOWN_PROBABILITY = 0.05;

    public Truck() {
        setName();
        setVehicleType();
    }

    @Override
    protected void setName() {
        name = Integer.toString(Util.getRandomNumber(0, 1000));
    }

    public int getBreakdownTurnsLeft() {
        return breakdownTurnsLeft;
    }

    @Override
    public void prepareForLap(Race race) {
        if (breakdownTurnsLeft > 0) {
            currentSpeed = 0;
            breakdownTurnsLeft --;
            race.decrementNumOfBrokenTrucks();
        } else {
            if (Util.prob(BREAKING_DOWN_PROBABILITY)) {
                race.incrementNumOfBrokenTrucks();
                breakdownTurnsLeft = BREAKDOWN_TURNS - 1;
                currentSpeed = 0;
            } else {
                currentSpeed = SPEED;
            }
        }

    }
}
