package org.example.service;

import org.example.domain.Plane;
import org.example.domain.PlaneCargo;
import org.example.domain.PlanePassenger;
import org.example.util.Hangar;

public class TotalOperationsServices {

    public static void listPlanes() { // old method
        if (Hangar.hangarPlanes.length > 0) {
            //Arrays.stream(Hangar.hangarPlanes).forEach(System.out::println);
            for (Plane plane : Hangar.hangarPlanes) {
                if (plane != null) {
                    System.out.println(plane);
                }
            }
        } else {
            System.out.println("You don't have any planes!");
        }
    }

    public static void updateHangarPlanesArray() { // erasing the Null objects
        Plane[] nonNullHangar = new Plane[countNonNullPlanes()];
        int number = 0;
        for (int i = 0; i < Hangar.hangarPlanes.length; i++) {
            if (Hangar.hangarPlanes[i] != null) {
                nonNullHangar[i - number] = Hangar.hangarPlanes[i];
            } else {
                number++;
            }
        }
        Hangar.hangarPlanes = nonNullHangar;
    }

    public static void totalPassCapacity() {
        //int totalCapacity = Arrays.stream(Hangar.hangarPlanes).filter(plane -> plane instanceof PlanePassenger).mapToInt(plane -> ((PlanePassenger) plane).getPassCapacity()).sum();
        int totalCapacity = 0;
        for (Plane hangarPlane : Hangar.hangarPlanes) {
            if (hangarPlane.isPassengerPlane()) {
                totalCapacity += ((PlanePassenger) hangarPlane).getPassCapacity();
            }
        }
        System.out.println("Total passenger capacity of planes in your hangar is " + totalCapacity);
    }

    public static void totalCargoCapacity() {
        //int totalCapacity = Arrays.stream(Hangar.hangarPlanes).filter(plane -> plane instanceof PlaneCargo).mapToInt(plane -> ((PlaneCargo) plane).getCarryCapacity()).sum();
        int totalCapacity = 0;
        for (Plane hangarPlane : Hangar.hangarPlanes) {
            if (!hangarPlane.isPassengerPlane()) {
                totalCapacity += ((PlaneCargo) hangarPlane).getCarryCapacity();
            }
        }
        System.out.println("Total cargo capacity of planes in your hangar is " + totalCapacity);
    }

    public static int countNonNullPlanes() {
        int sum = 0;
        for (Plane hangarPlane : Hangar.hangarPlanes) {
            if (hangarPlane != null) {
                sum++;
            }
        }
        return sum;
    }

    public static void totalAmountOfPlanes() {
        int sum = countNonNullPlanes();
        if (sum == 0) {
            System.out.println("There are no planes in your hangar.");
        } else if (sum == 1) {
            System.out.println("There is currently only " + sum + " plane in your hangar.");
        } else {
            System.out.println("There are currently " + sum + " planes in your hangar.");
        }

        /*if (Hangar.hangarPlanes.length == 0) {
            System.out.println("There are no planes in your hangar.");
        } else if (Hangar.hangarPlanes.length == 1) {
            System.out.println("There is currently only " + Hangar.hangarPlanes.length + " plane in your hangar.");
        } else {
            System.out.println("There are currently " + Hangar.hangarPlanes.length + " planes in your hangar.");
        }*/
    }
}
