package org.example;

import java.io.IOException;

public abstract class Plane {

    private String name;
    private double price;
    private int flightRange;
    private int speed;
    private int fuelCapacity;

    public Plane(String name, double price, int flightRange, int speed, int fuelCapacity) throws IOException {
        this.name = name;
        this.price = price;
        this.flightRange = flightRange;
        this.speed = speed;
        this.fuelCapacity = fuelCapacity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public int getSpeed() {
        return speed;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    @Override
    public String toString() {
        return "Plane[" +
                "name=" + name +
                ", price=" + price +
                ", flightRange=" + flightRange +
                ", speed=" + speed +
                ", fuelCapacity=" + fuelCapacity +
                ']';
    }
}
