package com.codecool.car_race;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Race {

    public static final int LAPS_IN_RACE = 50;

    public Weather weather;

    public List<Vehicle> vehicles = new ArrayList<>();

    public Race() {
        weather = new Weather();
    }

    public void simulateRace() {
        for (int j = 1; j <= LAPS_IN_RACE; j++) {
            weather.setRaining();
            vehicles.sort(Comparator.comparing(Vehicle::getVehicleValue));
            for (Vehicle vehicle :
                    vehicles) {
                vehicle.prepareForLap(this);
                vehicle.moveForAnHour();
            }
            int howManyPlacesToShow = vehicles.size();
            printLapResults(j, howManyPlacesToShow);
        }
    }

    public void printRaceResults() {
        vehicles.sort(Comparator.comparing(Vehicle::getDistanceTraveled).reversed());

        System.out.println("\n\n==== Final results ====");

        printCurrentResults(vehicles.size());
    }

    private void printLapResults(int lapNumber, int numOfPlacesToShow) {
        vehicles.sort(Comparator.comparing(Vehicle::getDistanceTraveled).reversed());

        System.out.println("\n>>> Results after lap " + lapNumber + ":");

        if (weather.isRaining()) {
            System.out.println("RAINING!");
        }

        if (getBrokeTruckNames().size() > 0) {
            StringBuilder sb = new StringBuilder("BROKEN TRUCK(S): ");
            List<String> brokenTruckNames = getBrokeTruckNames();
            sb.append(String.join(", ", brokenTruckNames));
            System.out.println(sb);
        }

        printCurrentResults(numOfPlacesToShow);
    }

    private void printCurrentResults(int numberOfLinesToPrint) {

        for (int i = 0; i < numberOfLinesToPrint; i++) {
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
