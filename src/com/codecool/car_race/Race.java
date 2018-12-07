package com.codecool.car_race;

import java.util.ArrayList;
import java.util.Collections;
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
            weather.setRaining();
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

        System.out.println("\n\n==== Final results ====");

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

            System.out.println(sb);

            place++;
        }
    }

    public void printLapResults(int lapNumber) {
        vehicles.sort(Comparator.comparing(Vehicle::getDistanceTraveled).reversed());

        System.out.println("\n>>> Results after lap " + lapNumber + ":");

        if (weather.isRaining()) {
            System.out.println("RAINING!");
        }

        if (anyBrokenTrucks) {
            StringBuilder sb = new StringBuilder("BROKEN TRUCKS: ");
            List<String> brokenTruckNames = getBrokeTruckNames();
            sb.append(String.join(", ", brokenTruckNames));
            System.out.println(sb);
        }

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

            System.out.println(sb);
        }
    }

    public List<String> getBrokeTruckNames() {
        List<String> names = new ArrayList<>();
        for (Vehicle vehicle :
                vehicles) {
            if (vehicle.vehicleType == Vehicle.VehicleType.TRUCK) {
                Truck truck = (Truck) vehicle;
                if (truck.getBreakdownTurnsLeft() > 0) {
                    names.add(vehicle.getName());
                }
            }
        }
        return names;
    }

}
