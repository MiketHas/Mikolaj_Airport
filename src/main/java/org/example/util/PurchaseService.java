package org.example.util;

import org.example.domain.Plane;
import service.Hangar;
import service.Reader;

import java.util.Arrays;
import java.util.Objects;

import static service.Hangar.hangar;
import static service.Hangar.planesToSell;

public class PurchaseService {

    public static void buyPlane() {
        System.out.println("""
                What kind of plane would you like to buy?
                (1) Passenger Plane
                (2) Cargo Plane
                (3) Go back to main menu""");

        int choice = Reader.errorHandling(3, "You didn't enter a correct numerical value! Please enter a number 1-3!");
        switch (choice) {
            case 1 -> buyPassengerPlane();
            case 2 -> buyCargoPlane();
            case 3 -> hangar();
        }
    }

    public static void buyPassengerPlane() {
        for (int i = 0; i < Hangar.planesToSell.length; i++) {
            /*if (Hangar.planesToSell[i] instanceof PlanePassenger) {*/
            if (Hangar.planesToSell[i] != null && Hangar.planesToSell[i].isPassengerPlane()) {
                addPlaneToHangar(Hangar.planesToSell[i]);
                Hangar.planesToSell[i] = null;
                //removeNullPlaneFromSell();
                System.out.println("Passenger plane added to your hangar!");
                return;
            }
        }
        System.out.println("Sorry, you already bought all passenger planes!");
    }

    public static void buyCargoPlane() {
        for (int i = 0; i < Hangar.planesToSell.length; i++) {
            /*if (Hangar.planesToSell[i] instanceof PlaneCargo) {*/
            if (Hangar.planesToSell[i] != null && !Hangar.planesToSell[i].isPassengerPlane()) {
                addPlaneToHangar(Hangar.planesToSell[i]);
                Hangar.planesToSell[i] = null;
                //removeNullPlaneFromSell();
                System.out.println("Cargo plane added to your hangar!");
                return;
            }
        }
        System.out.println("Sorry, you already bought all cargo planes!");
    }

    public static void addPlaneToHangar(Plane plane) {
        //Plane[] tempHangar = Arrays.copyOf(Hangar.hangarPlanes, Hangar.hangarPlanes.length + 1);
        Plane[] tempHangar = new Plane[Hangar.hangarPlanes.length + 1];
        for (int i = 0; i < Hangar.hangarPlanes.length; i++) {
            tempHangar[i] = Hangar.hangarPlanes[i];
        }
        tempHangar[tempHangar.length - 1] = plane;
        Hangar.hangarPlanes = tempHangar;
    }

    public static void removeNullPlaneFromSell() { // no longer needed
        planesToSell = Arrays.stream(planesToSell).filter(Objects::nonNull).toArray(Plane[]::new);
    }
}
