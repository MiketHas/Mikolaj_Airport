package org.example;

import java.util.Arrays;
import java.util.Objects;

import static org.example.Hangar.*;

public class Buy {

    public static void buyPlane() {
        System.out.println("What kind of plane would you like to buy?" + "\n" + "(1) Passenger Plane" + "\n" + "(2) Cargo Plane" + "\n" + "(3) Go back to main menu");

        int userInput  = input.nextInt();
        switch (userInput) {
            case 1 -> buyPassengerPlane();
            case 2 -> buyCargoPlane();
            case 3 -> hangar();
        }
    }

    public static void buyPassengerPlane() {
        for (int i=0; i<Hangar.planesToSell.length; i++) {
            if (Hangar.planesToSell[i] instanceof PlanePassenger) {
                addPlaneToHangar(Hangar.planesToSell[i]);
                Hangar.planesToSell[i] = null;
                removeNullPlaneFromSell();
                System.out.println("Passenger plane added to your hangar!");
                return;
            }
        }
        System.out.println("Sorry, you already bought all passenger planes!");
    }

    public static void buyCargoPlane() {
        for (int i=0; i<Hangar.planesToSell.length; i++) {
            if (Hangar.planesToSell[i] instanceof PlaneCargo) {
                addPlaneToHangar(Hangar.planesToSell[i]);
                Hangar.planesToSell[i] = null;
                removeNullPlaneFromSell();
                System.out.println("Cargo plane added to your hangar!");
                return;
            }
        }
        System.out.println("Sorry, you already bought all cargo planes!");
    }

    public static void addPlaneToHangar(Plane plane) {
        /*Plane[] tempHangar = new Plane[hangarPlanes.length+1];
          System.arraycopy(hangarPlanes, 0, tempHangar, 0, hangarPlanes.length);*/
        Plane[] tempHangar = Arrays.copyOf(Hangar.hangarPlanes, Hangar.hangarPlanes.length+1);
        tempHangar[tempHangar.length-1] = plane;
        Hangar.hangarPlanes = tempHangar;
    }

    public static void removeNullPlaneFromSell() {
        planesToSell = Arrays.stream(planesToSell).filter(Objects::nonNull).toArray(Plane[]::new);
    }
}
