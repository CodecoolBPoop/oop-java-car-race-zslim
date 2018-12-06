package com.codecool.car_race;

public class Truck extends Vehicle {

    private int breakdownTurnsLeft;

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
            if (Util.prob(0.05)) {
                race.anyBrokenTrucks = true;
                breakdownTurnsLeft = 2;
            }
        }

    }
}
