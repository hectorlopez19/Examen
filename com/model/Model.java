package com.model;

public class Model {
    private EcotourismHotel[] hotels;
    private int registeredHotels;

    public Model() {
        this.hotels = new EcotourismHotel[15];
        this.registeredHotels = 0;
    }

    public EcotourismHotel[] getHotels() {
        return hotels;
    }

    public void setHotels(EcotourismHotel[] hotels) {
        this.hotels = hotels;
    }

    public int getRegisteredHotels() {
        return registeredHotels;
    }

    public void setRegisteredHotels(int registeredHotels) {
        this.registeredHotels = registeredHotels;
    }

    public void register(String name, String location, int atractionsNumber, float cost, int capacity, int stars) {
        hotels[registeredHotels] = new EcotourismHotel(name, location, atractionsNumber, cost, capacity, stars);
        registeredHotels++;
    }

    public int search(String name) {
        for(int i = 0; i < registeredHotels; i++) {
            if(hotels[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int index) {
        for(int i = index; i < registeredHotels; i++) {
            hotels[i] = hotels[i + 1];
        }
        System.gc();
        registeredHotels--;
    }
}
