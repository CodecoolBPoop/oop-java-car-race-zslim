package com.codecool.car_race;

abstract class Vehicle {

    protected String name;

    private int distanceTraveled;

    protected int currentSpeed;

    protected abstract void setName();
    public String getName() {
        return name;
    }

    abstract void prepareForLap(Race race);

    public void moveForAnHour() {
        distanceTraveled += currentSpeed;
    }
}
