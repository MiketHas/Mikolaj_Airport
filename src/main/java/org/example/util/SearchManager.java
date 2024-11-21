package org.example.util;

import service.Hangar;
import service.Reader;

import static service.Hangar.hangar;
import static service.Hangar.input;

public class SearchManager {

    public static void searchPlane() {
        System.out.println("\n" + """
                What parameter would you like to use to search for your plane?
                (1) By name.
                (2) By speed.
                (3) By fuel capacity.
                (4) Go back to main menu.""");

        int choice = Reader.errorHandling(4, "You didn't enter a correct numerical value! Please enter a number 1-4!");
        switch (choice) {
            case 1 -> byName();
            case 2 -> bySpeed();
            case 3 -> byFuelCap();
            case 4 -> hangar();
            default -> {
                System.out.println("Please enter a number 1-4");
                searchPlane();
            }
        }
    }

    public static void byName() {
        System.out.println("Please enter the name of your desired plane.");
        input.nextLine();
        String userInput = input.nextLine();
        /*Plane[] tempHangar = Arrays.copyOf(Hangar.hangarPlanes, Hangar.hangarPlanes.length);
        tempHangar = Arrays.stream(tempHangar).filter(s -> s.getName().contains(userInput)).toArray(Plane[]::new);*/
        int num = 0;
        for (int i = 0; i < Hangar.hangarPlanes.length; i++) {
            if (Hangar.hangarPlanes[i].getName().contains(userInput)) {
                System.out.println(Hangar.hangarPlanes[i]);
                ++num;
            }
        }

        if (num == 0) {
            System.out.println("Sorry, couldn't find a match!");
            searchPlane();
        }
    }

    public static void bySpeed() {
        System.out.println("Please enter the speed of your desired plane.");
        /*Plane[] tempHangar = Arrays.copyOf(Hangar.hangarPlanes, Hangar.hangarPlanes.length);
        tempHangar = Arrays.stream(tempHangar).filter(s -> s.getSpeed() == userInput).toArray(Plane[]::new);*/
        int choice = Reader.searchErrorHandling("You didn't enter a correct numerical value!");
        int num = 0;
        for (int i = 0; i < Hangar.hangarPlanes.length; i++) {
            if (Hangar.hangarPlanes[i].getSpeed() == choice) {
                System.out.println(Hangar.hangarPlanes[i]);
                ++num;
            }
        }

        if (num == 0) {
            System.out.println("Sorry, couldn't find a match!");
            searchPlane();
        }
    }

    public static void byFuelCap() {
        System.out.println("Please enter the fuel capacity of your desired plane.");
        /*Plane[] tempHangar = Arrays.copyOf(Hangar.hangarPlanes, Hangar.hangarPlanes.length);
        tempHangar = Arrays.stream(tempHangar).filter(s -> s.getFuelCapacity() == userInput).toArray(Plane[]::new);*/
        int choice = Reader.searchErrorHandling("You didn't enter a correct numerical value!");
        int num = 0;
        for (int i = 0; i < Hangar.hangarPlanes.length; i++) {
            if (Hangar.hangarPlanes[i].getFuelCapacity() == choice) {
                System.out.println(Hangar.hangarPlanes[i]);
                ++num;
            }
        }

        if (num == 0) {
            System.out.println("Sorry, couldn't find a match!");
            searchPlane();
        }
    }
}
