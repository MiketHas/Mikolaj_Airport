package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {

    public static void sortByFlight() {
        Plane[] tempHangar = Arrays.copyOf(Hangar.hangarPlanes, Hangar.hangarPlanes.length);
        Arrays.sort(tempHangar, Comparator.comparing(Plane:: getFlightRange));
        for(Plane plane: tempHangar) {
            System.out.println(plane);
        }
        System.out.println();
    }
}
