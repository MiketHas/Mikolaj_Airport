package org.example.util;

import org.example.domain.Plane;
import service.Hangar;

public class SortPlaneService {

    public static void sortByFlight() {
        // replacement for Arrays.copyOf with the usage of countNonNullPlanes()
        Plane[] tempHangar = new Plane[TotalOperationsServices.countNonNullPlanes()];
        int number = 0;
        for (int i = 0; i < Hangar.hangarPlanes.length; i++) {
            if (Hangar.hangarPlanes[i] != null) {
                tempHangar[i - number] = Hangar.hangarPlanes[i];
            } else {
                number++;
            }
        }

        // replacement for Arrays.sort(tempHangar, Comparator.comparing(Plane:: getFlightRange));
        for (int i = 0; i < tempHangar.length - 1; i++) {
            for (int j = 0; j < tempHangar.length - i - 1; j++) {
                if (tempHangar[j].getFlightRange() > tempHangar[j + 1].getFlightRange()) {
                    Plane tempPlane = tempHangar[j];
                    tempHangar[j] = tempHangar[j + 1];
                    tempHangar[j + 1] = tempPlane;
                }
            }
        }

        for (Plane plane : tempHangar) {
            System.out.println(plane);
        }
        System.out.println();
    }
}
