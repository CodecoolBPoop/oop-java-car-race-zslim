package com.codecool.car_race;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {

    public boolean anyBrokenTrucks;

    public Weather weather;

    public List<Vehicle> vehicles = new ArrayList<>();

    public Race() {
        weather = new Weather();
        anyBrokenTrucks = false;
    }

    public void simulateRace() {
        for (int j = 1; j < 50; j++) {
            System.out.println("== " + j + "th hour (lap) ==");
            for (Vehicle vehicle :
                    vehicles) {
                vehicle.prepareForLap(this);
                vehicle.moveForAnHour();
            }
            printLapResults(j);
        }
    }

    public void printRaceResults() {
        vehicles.sort(Comparator.comparing(Vehicle::getDistanceTraveled).reversed());
        int place = 1;

        System.out.println("==== Final results ====");

        for (Vehicle vehicle :
                vehicles) {
            StringBuilder sb = new StringBuilder();

            sb.append(place);
            sb.append(". ");
            sb.append(vehicle.getVehicleType().toString());
            sb.append(" ");
            sb.append(vehicle.getName());
            sb.append(", ");
            sb.append(vehicle.getDistanceTraveled());

            place++;
        }
    }

    public void printLapResults(int lapNumber) {
        vehicles.sort(Comparator.comparing(Vehicle::getDistanceTraveled).reversed());

        System.out.println("Results after lap " + lapNumber + ":");
        for (int i = 0; i < 10; i++) {
            Vehicle currentVehicle = vehicles.get(i);
            StringBuilder sb = new StringBuilder();

            sb.append(i + 1);
            sb.append(". ");
            sb.append(currentVehicle.getVehicleType().toString());
            sb.append(" ");
            sb.append(currentVehicle.getName()); // TODO: doesn't show error if I just access name here although it's supposed to be protected
            sb.append(", ");
            sb.append(currentVehicle.getDistanceTraveled());
        }
    }

}
