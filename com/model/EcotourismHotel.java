package com.model;

public class EcotourismHotel extends EcotourismPlace{
    private int capacity;
    private int stars;

    public EcotourismHotel(String name, String ubication, int atractionsNumber, float cost, int capacity, int stars) {
        super(name, ubication, atractionsNumber, cost);
        this.capacity = capacity;
        this.stars = stars;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
