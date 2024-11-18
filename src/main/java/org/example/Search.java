package org.example;

import org.apache.logging.log4j.core.util.JsonUtils;

import java.util.Arrays;

import static org.example.Hangar.hangar;
import static org.example.Hangar.input;

public class Search {

    public static void searchPlane() {
        System.out.println("\n" + "What parameter would you like to use to search for your plane?");
        System.out.println("(1) By name.");
        System.out.println("(2) By speed.");
        System.out.println("(3) By fuel capacity.");
        System.out.println("(4) Go back to main menu.");
        try{
            int userInput  = input.nextInt();
            switch (userInput) {
                case 1 -> byName();
                case 2 -> bySpeed();
                case 3 -> byFuelCap();
                case 4 -> hangar();
                default -> {
                    System.out.println("Please enter a number 1-4");
                    searchPlane();
                }
            }
        } catch (Exception e) {
            System.out.println("You didn't type a number! Please enter a number 1-4");
            input.nextLine();
            searchPlane();
        }
    }

    public static void byName() {
        System.out.println("Please enter the name of your desired plane.");
        input.nextLine();
        String userInput = input.nextLine();
        /*for (int i=0; i<Hangar.hangarPlanes.length; i++) {
            if (Hangar.hangarPlanes[i].getName().contains(userInput)) {
                System.out.println(Hangar.hangarPlanes[i]);
            } else {
                System.out.println("Sorry, couldn't find a match!");
                searchPlane();
            }
        }*/
        Plane[] tempHangar = Arrays.copyOf(Hangar.hangarPlanes, Hangar.hangarPlanes.length);
        tempHangar = Arrays.stream(tempHangar).filter(s -> s.getName().contains(userInput)).toArray(Plane[]::new);
        if (tempHangar.length>0) {
            Arrays.stream(tempHangar).forEach(System.out::println);
        } else {
            System.out.println("Sorry, couldn't find a match!");
            searchPlane();
        }


    }

    public static void bySpeed() {
        System.out.println("Please enter the speed of your desired plane.");
        try {
            input.nextLine();
            int userInput = input.nextInt();
            Plane[] tempHangar = Arrays.copyOf(Hangar.hangarPlanes, Hangar.hangarPlanes.length);
            tempHangar = Arrays.stream(tempHangar).filter(s -> s.getSpeed()==userInput).toArray(Plane[]::new);
            if (tempHangar.length>0) {
                Arrays.stream(tempHangar).forEach(System.out::println);
            } else {
                System.out.println("Sorry, couldn't find a match!");
                searchPlane();
            }
        } catch (Exception e) {
            System.out.println("You didn't enter a numeric value!");
            input.nextLine();
            searchPlane();
        }

    }

    public static void byFuelCap() {
        System.out.println("Please enter the fuel capacity of your desired plane.");
        try {
            input.nextLine();
            int userInput = input.nextInt();
            Plane[] tempHangar = Arrays.copyOf(Hangar.hangarPlanes, Hangar.hangarPlanes.length);
            tempHangar = Arrays.stream(tempHangar).filter(s -> s.getFuelCapacity()==userInput).toArray(Plane[]::new);
            if (tempHangar.length>0) {
                Arrays.stream(tempHangar).forEach(System.out::println);
            } else {
                System.out.println("Sorry, couldn't find a match!");
                searchPlane();
            }
        } catch (Exception e) {
            System.out.println("You didn't enter a numeric value!");
            input.nextLine();
            searchPlane();
        }

    }
}
