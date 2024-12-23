package org.example.domain;

import java.io.IOException;

public class PlanePassenger extends Plane {

    private int passCapacity;

    public PlanePassenger(String name, double price, int flightRange, int speed, int fuelCapacity, int passCapacity) {
        super(name, price, flightRange, speed, fuelCapacity);
        this.passCapacity = passCapacity;
    }

    public int getPassCapacity() {
        return this.passCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("]", ", Passenger Capacity = " + passCapacity + "]");
    }

    @Override
    public boolean isPassengerPlane() {
        return true;
    }
}
