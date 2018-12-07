package com.codecool.car_race;

public class Car extends Vehicle {

    private static final int MAX_SPEED_IF_BROKE_TRUCK = 75;
    private static final int NORMAL_SPEED_MIN = 80;
    private static final int NORMAL_SPEED_MAX = 110;
    private static final double RAIN_DISADVANTAGE_MIN = 0.7;
    private static final double RAIN_DISADVANTAGE_MAX = 0.9;

    private double rainDisadvantage;

    private int normalSpeed;

    private String[] nameList = {"Eon", "Blaze", "Vanish", "Wish", "Supremacy", "Liberty", "Pyre", "Empyrean", "Silver",
                                 "Instinct", "Twister", "Eos", "Charm", "Aura", "Crux", "Roamer", "Zeal", "Vision",
                                 "Avalanche", "Inquiry", "Passion", "Bliss", "Capital", "Bullet", "Lightning", "Pinnacle",
                                 "Harmony", "Vagabond", "Resolve", "Lightning", "Empire", "Vertex", "Millenium", "Roamer",
                                 "Thunder", "Blade", "Nimbus", "Adventure", "Parallel", "Nimbus", "Grit", "Vertex",
                                 "Alabaster", "Prime", "Guerilla", "Deputy", "Raven", "Majesty", "Tarragon", "Crusader",
                                 "Tigress"};

    public Car() {
        setName();
        setVehicleType();
        setNormalSpeed();
        setRainDisadvantage();
    }

    @Override
    protected void setName() { // TODO: why can't this be private?
        name = nameList[Util.getRandomNumber(0, nameList.length - 1)] + " " + nameList[Util.getRandomNumber(0, nameList.length - 1)];
    }

    private void setNormalSpeed() {
        normalSpeed = Util.getRandomNumber(NORMAL_SPEED_MIN, NORMAL_SPEED_MAX);
    }

    private void setRainDisadvantage() {
        rainDisadvantage = Util.getRandomNumber(RAIN_DISADVANTAGE_MIN, RAIN_DISADVANTAGE_MAX);
    }

    @Override
    public void prepareForLap(Race race) {
        if (race.getNumOfBrokenTrucks() > 0) {
            currentSpeed = MAX_SPEED_IF_BROKE_TRUCK;
        } else if (race.weather.isRaining()) {
            currentSpeed = Util.round(normalSpeed * rainDisadvantage);
        } else {
            currentSpeed = normalSpeed;
        }
    }
}
