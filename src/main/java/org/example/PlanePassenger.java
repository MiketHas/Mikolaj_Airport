package org.example;

import java.io.IOException;

public class PlanePassenger extends Plane {

    private int passCapacity;

    public PlanePassenger(String name, double price, int flightRange, int speed, int fuelCapacity, int passCapacity) throws IOException {
        super(name, price, flightRange, speed, fuelCapacity);
        this.passCapacity = passCapacity;
    }

    public int getPassCapacity() {
        return passCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("]", ", Passenger Capacity=" + passCapacity + "]");
    }
}
