package com.codecool.car_race;

import java.util.ArrayList;
import java.util.List;

public class Race {

    public boolean anyBrokenTrucks;

    public Weather weather;

    public List<Motorcycle> motorcycles = new ArrayList<>();

    public Race() {
        weather = new Weather();
        anyBrokenTrucks = false;
    }

    public void simulateRace() {

    }

    public void printRaceResults() {

    }

}
