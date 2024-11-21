package org.example.util;

import org.example.domain.Plane;
import service.Hangar;
import service.Reader;

import java.util.Arrays;
import java.util.Objects;

import static service.Hangar.hangar;

public class SellService {

    public static void sellPlane() {
        System.out.println("""
                What kind of plane would you like to sell?
                (1) Passenger Plane
                (2) Cargo Plane"
                (3) Go back to main menu""");

        int choice = Reader.errorHandling(3, "You didn't enter a correct numerical value! Please enter a number 1-3!");
        switch (choice) {
            case 1 -> sellPassengerPlane();
            case 2 -> sellCargoPlane();
            case 3 -> hangar();
        }
    }

    public static void sellPassengerPlane() {
        for (int i = 0; i < Hangar.hangarPlanes.length; i++) {
            /*if (Hangar.hangarPlanes[i] instanceof PlanePassenger) {*/
            if (Hangar.hangarPlanes[i].isPassengerPlane()) {
                addPlaneToMarket(Hangar.hangarPlanes[i]);
                Hangar.hangarPlanes[i] = null;
                TotalOperationsServices.updateHangarPlanesArray();
                // removeNullPlaneFromHangar(); // <-- replaced with TotalOperationsServices.updateHangarPlanesArray();
                System.out.println("Passenger plane sold and removed from your hangar!");
                return;
            }
        }
        System.out.println("Sorry, you already sold all passenger planes!");
    }

    public static void sellCargoPlane() {
        for (int i = 0; i < Hangar.hangarPlanes.length; i++) {
            /*if (Hangar.hangarPlanes[i] instanceof PlanePassenger) {*/
            if (!Hangar.hangarPlanes[i].isPassengerPlane()) {
                addPlaneToMarket(Hangar.hangarPlanes[i]);
                Hangar.hangarPlanes[i] = null;
                TotalOperationsServices.updateHangarPlanesArray();
                // removeNullPlaneFromHangar(); // <-- replaced with TotalOperationsServices.updateHangarPlanesArray();
                System.out.println("Cargo plane sold and removed from your hangar!");
                return;
            }
        }
        System.out.println("Sorry, you already sold all cargo planes!");
    }

    public static void addPlaneToMarket(Plane plane) {
        //Plane[] tempHangar = Arrays.copyOf(Hangar.planesToSell, Hangar.planesToSell.length + 1);
        Plane[] tempHangar = new Plane[Hangar.planesToSell.length + 1];
        for (int i = 0; i < Hangar.planesToSell.length; i++) {
            tempHangar[i] = Hangar.planesToSell[i];
        }
        tempHangar[tempHangar.length - 1] = plane;
        Hangar.planesToSell = tempHangar;
    }

    public static void removeNullPlaneFromHangar() { // we're now removing Nulls via TotalOperationsServices.onlyNonNullPlanesArray()
        Hangar.hangarPlanes = Arrays.stream(Hangar.hangarPlanes).filter(Objects::nonNull).toArray(Plane[]::new);
    }
}
