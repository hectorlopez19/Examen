package com.model;

public class EcotourismPlace {
    private String name;
    private String location;
    private int atractionsNumber;
    private float cost;

    public EcotourismPlace(String name, String location, int atractionsNumber, float cost) {
        this.name = name;
        this.location = location;
        this.atractionsNumber = atractionsNumber;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAtractionsNumber() {
        return atractionsNumber;
    }

    public void setAtractionsNumber(int atractionsNumber) {
        this.atractionsNumber = atractionsNumber;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
