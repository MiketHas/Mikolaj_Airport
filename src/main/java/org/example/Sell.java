package org.example;

import java.util.Arrays;
import java.util.Objects;

import static org.example.Hangar.hangar;
import static org.example.Hangar.input;

public class Sell {

    public static void sellPlane() {
        System.out.println("What kind of plane would you like to sell?" + "\n" + "(1) Passenger Plane" + "\n" + "(2) Cargo Plane" + "\n" + "(3) Go back to main menu");

        int userInput  = input.nextInt();
        switch (userInput) {
            case 1 -> sellPassengerPlane();
            case 2 -> sellCargoPlane();
            case 3 -> hangar();
        }
    }

    public static void sellPassengerPlane() {
        for (int i=0; i<Hangar.hangarPlanes.length; i++) {
            if (Hangar.hangarPlanes[i] instanceof PlanePassenger) {
                addPlaneToMarket(Hangar.hangarPlanes[i]);
                Hangar.hangarPlanes[i] = null;
                removeNullPlaneFromHangar();
                System.out.println("Passenger plane sold and removed from your hangar!");
                return;
            }
        }
        System.out.println("Sorry, you already sold all passenger planes!");
    }

    public static void sellCargoPlane() {
        for (int i=0; i<Hangar.hangarPlanes.length; i++) {
            if (Hangar.hangarPlanes[i] instanceof PlaneCargo) {
                addPlaneToMarket(Hangar.hangarPlanes[i]);
                Hangar.hangarPlanes[i] = null;
                removeNullPlaneFromHangar();
                System.out.println("Cargo plane sold and removed from your hangar!");
                return;
            }
        }
        System.out.println("Sorry, you already sold all cargo planes!");
    }

    public static void addPlaneToMarket(Plane plane) {
        Plane[] tempHangar = Arrays.copyOf(Hangar.planesToSell, Hangar.planesToSell.length+1);
        tempHangar[tempHangar.length-1] = plane;
        Hangar.planesToSell = tempHangar;
    }

    public static void removeNullPlaneFromHangar() {
        Hangar.hangarPlanes = Arrays.stream(Hangar.hangarPlanes).filter(Objects::nonNull).toArray(Plane[]::new);
    }
}
