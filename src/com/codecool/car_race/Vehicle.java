package com.codecool.car_race;

abstract class Vehicle {

    protected String name;
    protected VehicleType vehicleType;

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

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    protected void setVehicleType() {
        if (this instanceof Car) {
            vehicleType = VehicleType.CAR;
        } else if (this instanceof Motorcycle) {
            vehicleType = VehicleType.MOTORCYCLE;
        } else if (this instanceof Truck) {
            vehicleType = VehicleType.TRUCK;
        }
    }

    public int getVehicleValue() {
        return vehicleType.value;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    enum VehicleType {
        TRUCK(0), CAR(1), MOTORCYCLE(2);

        private int value;

        VehicleType(int value) {
            this.value = value;
        }

    }
}
