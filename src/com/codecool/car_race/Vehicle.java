package com.codecool.car_race;

abstract class Vehicle {

    protected String name;

    private int distanceTraveled;

    protected int currentSpeed;

    abstract void setName(); // TODO: how should I declare this so that it can be private when implemented?
    public String getName() {
        return name;
    }

    abstract void prepareForLap(Race race);

    public void moveForAnHour() {
        distanceTraveled ++;
    }
}
