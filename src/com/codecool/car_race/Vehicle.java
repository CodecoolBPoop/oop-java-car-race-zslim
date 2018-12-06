package com.codecool.car_race;

abstract class Vehicle {

    private String name;

    private int distanceTraveled;

    private int currentSpeed;

    abstract void setName();
    public String getName() {
        return name;
    }

    abstract void prepareForLap(Race race);

    public void moveForAnHour() {
        distanceTraveled ++;
    }
}
