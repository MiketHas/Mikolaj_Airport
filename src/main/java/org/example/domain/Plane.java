package org.example.domain;

import java.io.IOException;

public abstract class Plane {

    private String name;
    private double price;
    private int flightRange;
    private int speed;
    private int fuelCapacity;

    public Plane(String name, double price, int flightRange, int speed, int fuelCapacity) {
        this.name = name;
        this.price = price;
        this.flightRange = flightRange;
        this.speed = speed;
        this.fuelCapacity = fuelCapacity;
    }

    public static Plane createPlane(PlaneTypes type, String name, double price, int flightRange, int speed, int fuelCapacity, int passCapacity, int cargoCapacity) throws IOException {
        return switch (type) {
            case PASSENGER -> new PlanePassenger(name, price, flightRange, speed, fuelCapacity, passCapacity);
            case CARGO -> new PlaneCargo(name, price, flightRange, speed, fuelCapacity, cargoCapacity);
        };
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

    public abstract boolean isPassengerPlane();

    @Override
    public String toString() {
        return "Plane[" +
                "name = " + name +
                ", price = " + price +
                ", flightRange = " + flightRange +
                ", speed = " + speed +
                ", fuelCapacity = " + fuelCapacity +
                ']';
    }
}
