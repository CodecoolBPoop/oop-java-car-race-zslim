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
            breakdownTurnsLeft --;
            if (breakdownTurnsLeft == 0) {
                currentSpeed = SPEED;
            }
        } else {
            if (Util.prob(BREAKING_DOWN_PROBABILITY)) {
                breakdownTurnsLeft = BREAKDOWN_TURNS;
                currentSpeed = 0;
            } else {
                currentSpeed = SPEED;
            }
        }

    }
}
