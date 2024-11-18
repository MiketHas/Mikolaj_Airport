package org.example;

import java.util.Arrays;

public class TotalCalculations {

    public static void totalPassCapacity() {
        int totalCapacity = Arrays.stream(Hangar.hangarPlanes).filter(plane -> plane instanceof PlanePassenger).mapToInt(plane -> ((PlanePassenger) plane).getPassCapacity()).sum();
        System.out.println("Total passenger capacity of planes in your hangar is " + totalCapacity);
    }

    public static void totalCargoCapacity() {
        int totalCapacity = Arrays.stream(Hangar.hangarPlanes).filter(plane -> plane instanceof PlaneCargo).mapToInt(plane -> ((PlaneCargo) plane).getCarryCapacity()).sum();
        System.out.println("Total cargo capacity of planes in your hangar is " + totalCapacity);
    }

    public static void totalAmountOfPlanes() {
        if (Hangar.hangarPlanes.length==0) {
            System.out.println("There are no planes in your hangar.");
        } else if (Hangar.hangarPlanes.length==1) {
            System.out.println("There is currently only " + Hangar.hangarPlanes.length + " plane in your hangar.");
        } else {
            System.out.println("There are currently " + Hangar.hangarPlanes.length + " planes in your hangar.");
        }
    }
}
