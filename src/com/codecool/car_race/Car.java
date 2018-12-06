package com.codecool.car_race;

public class Car extends Vehicle {

    private double normalSpeed;

    private String name;
    private String[] nameList = {"Eon", "Blaze", "Vanish", "Wish", "Supremacy", "Liberty", "Pyre", "Empyrean", "Silver",
                                 "Instinct", "Twister", "Eos", "Charm", "Aura", "Crux", "Roamer", "Zeal", "Vision",
                                 "Avalanche", "Inquiry", "Passion", "Bliss", "Capital", "Bullet", "Lightning", "Pinnacle",
                                 "Harmony", "Vagabond", "Resolve", "Lightning", "Empire", "Vertex", "Millenium", "Roamer",
                                 "Thunder", "Blade", "Nimbus", "Adventure", "Parallel", "Nimbus", "Grit", "Vertex",
                                 "Alabaster", "Prime", "Guerilla", "Deputy", "Raven", "Majesty", "Tarragon", "Crusader",
                                 "Tigress"};

    public void setName() {
        name = nameList[Util.getRandomInt(0, nameList.length - 1)] + nameList[Util.getRandomInt(0, nameList.length - 1)];
    }
}
