package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Hangar {

    static Plane[] planesToSell = DataProvider.planeArray;
    static Plane[] hangarPlanes = new Plane[0];
    static Scanner input = new Scanner(System.in);

    public static void hangar() {
        System.out.println("\n" + "Welcome to the Plane purchase/Sell system. What would you like to do?");
        System.out.println("1. Purchase a new plane.");
        System.out.println("2. Sell a plane.");
        System.out.println("3. List all the planes in your hangar.");
        System.out.println("4. Sort planes by flight range.");
        System.out.println("5. Calculate overall passenger capacity across all of your passenger planes.");
        System.out.println("6. Calculate overall cargo capacity across all of your cargo planes.");
        System.out.println("7. Search for a plane.");
        System.out.println("8. Get the overall number of planes in the hangar.");
        System.out.println("9. Exit the app.");
        menu();
    }

    public static void menu() {
        try {
            int userInput = input.nextInt();
            System.out.println();
            switch (userInput) {
                case 1 -> {
                    Buy.buyPlane();
                    hangar();
                }
                case 2 -> {
                    Sell.sellPlane();
                    hangar();
                }
                case 3 -> {
                    listPlanes();
                    hangar();
                }
                case 4 -> {
                    Sort.sortByFlight();
                    hangar();
                }
                case 5 -> {
                    TotalCalculations.totalPassCapacity();
                    hangar();
                }
                case 6 -> {
                    TotalCalculations.totalCargoCapacity();
                    hangar();
                }
                case 7 -> {
                    Search.searchPlane();
                    hangar();
                }
                case 8 -> {
                    TotalCalculations.totalAmountOfPlanes();
                    hangar();
                }
                case 9 -> exit();
                default -> {
                    System.out.println("Please enter a number 1-9");
                    hangar();
                }
            }
        } catch (Exception e) {
            System.out.println("You didn't type a number! Please enter a number 1-9");
            input.nextLine(); // required to clear the invalid input
            hangar();
        }
    }

    public static void listPlanes() {
        Arrays.stream(hangarPlanes).forEach(System.out::println);
    }

    public static void exit() {
        System.exit(0);
    }
}
