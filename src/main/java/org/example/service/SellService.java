package org.example.service;

import org.example.domain.Plane;
import org.example.domain.PlaneTypes;
import org.example.util.Hangar;

import java.util.Arrays;
import java.util.Objects;

import static org.example.domain.PlaneTypes.CARGO;
import static org.example.domain.PlaneTypes.PASSENGER;
import static org.example.util.Hangar.hangar;
import static org.example.util.Hangar.hangarPlanes;

public class SellService {

    public static void sellPlane() {
        System.out.println("""
                What kind of plane would you like to sell?
                (1) Passenger Plane
                (2) Cargo Plane
                (3) Go back to main menu""");

        int choice = Reader.errorHandling(3, "You didn't enter a correct numerical value! Please enter a number 1-3!");
        switch (choice) {
            case 1 -> sellPlane(PASSENGER);
            case 2 -> sellPlane(CARGO);
            case 3 -> hangar();
        }
    }

    public static void sellPlane(PlaneTypes type) {
        if (!containsPlaneType(type)) {
            System.out.println((type==PASSENGER) ? "Sorry, you already sold all passenger planes!" : "Sorry, you already sold all cargo planes!");
            return;
        }

        for (int i = 0; i < Hangar.hangarPlanes.length; i++) {
            if (checkPlaneType(Hangar.hangarPlanes[i], type)) {
                addPlaneToMarket(Hangar.hangarPlanes[i]);
                Hangar.hangarPlanes[i] = null;
                //TotalOperationsServices.updateHangarPlanesArray(); also removeNullPlaneFromHangar() would do the same
                //removeNullPlaneFromSell();
                System.out.println(type == PASSENGER ? "Passenger plane sold and removed from your hangar!" : "Cargo plane sold and removed from your hangar!");
                return;
            }
        }
    }

    public static boolean checkPlaneType(Plane plane, PlaneTypes type) {
        return ((plane!=null) && ((plane.isPassengerPlane() && type == PASSENGER) || ((!plane.isPassengerPlane()) && type == CARGO)));
    }

    public static boolean containsPlaneType(PlaneTypes type) {
        for (Plane plane : hangarPlanes) {
            if (checkPlaneType(plane, type)) {
                return true;
            }
        } return false;
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
