package org.example.domain;

import java.io.IOException;

public class PlaneCargo extends Plane {

    private int carryCapacity;

    public PlaneCargo(String name, double price, int flightRange, int speed, int fuelCapacity, int carryCapacity) throws IOException {
        super(name, price, flightRange, speed, fuelCapacity);
        this.carryCapacity = carryCapacity;
    }

    public int getCarryCapacity() {
        return carryCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("]", ", Carry Capacity=" + carryCapacity + "]");
    }

    @Override
    public boolean isPassengerPlane() {
        return false;
    }
}
