package org.example.service;

import org.example.domain.Plane;
import org.example.domain.PlaneTypes;
import org.example.util.Hangar;

import java.util.Arrays;
import java.util.Objects;

import static org.example.domain.PlaneTypes.CARGO;
import static org.example.domain.PlaneTypes.PASSENGER;
import static org.example.util.Hangar.hangar;
import static org.example.util.Hangar.planesToSell;

public class PurchaseService {

    public static void buyPlane() {
        System.out.println("""
                What kind of plane would you like to buy?
                (1) Passenger Plane
                (2) Cargo Plane
                (3) Go back to main menu""");

        int choice = Reader.errorHandling(3, "You didn't enter a correct numerical value! Please enter a number 1-3!");
        switch (choice) {
            case 1 -> buyPlane(PASSENGER);
            case 2 -> buyPlane(CARGO);
            case 3 -> hangar();
        }
    }

    public static void buyPlane(PlaneTypes type) {
        for (int i = 0; i < Hangar.planesToSell.length; i++) {
            if (Hangar.planesToSell[i] != null && checkPlaneType(Hangar.planesToSell[i], type)) {
                addPlaneToHangar(Hangar.planesToSell[i]);
                Hangar.planesToSell[i] = null;
                //removeNullPlaneFromSell();
                System.out.println(type == PASSENGER ? "Passenger plane added to your hangar!" : "Cargo plane added to your hangar!");
                return;
            }
        }
        System.out.println(type == PASSENGER ? "Sorry, you already bought all passenger planes!" : "Sorry, you already bought all cargo planes!");
    }

    public static boolean checkPlaneType(Plane plane, PlaneTypes type) {
        return ((plane.isPassengerPlane() && type == PASSENGER) || ((!plane.isPassengerPlane()) && type == CARGO));
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
