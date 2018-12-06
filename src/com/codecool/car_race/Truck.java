package com.codecool.car_race;

public class Truck extends Vehicle {

    private int breakdownTurnsLeft;

    private static final int SPEED = 100;
    private static final int BREAKDOWN_TURNS = 2;
    private static final double BREAKING_DOWN_PROBABILITY = 0.05;

    @Override
    protected void setName() {
        name = Integer.toString(Util.getRandomNumber(0, 1000));
    }

    @Override
    public void prepareForLap(Race race) {
        if (breakdownTurnsLeft > 0) {
            currentSpeed = 0; // TODO: this case should be handled in MoveForAnHour
            breakdownTurnsLeft --;
        } else {
            if (Util.prob(BREAKING_DOWN_PROBABILITY)) {
                race.anyBrokenTrucks = true;
                breakdownTurnsLeft = BREAKDOWN_TURNS;
            } else {
                currentSpeed = SPEED;
            }
        }

    }
}
