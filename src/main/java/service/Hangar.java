package service;

import org.example.domain.Plane;
import org.example.util.PurchaseService;
import org.example.util.SearchManager;
import org.example.util.SellService;
import org.example.util.SortPlaneService;
import org.example.util.TotalOperationsServices;

import java.util.Scanner;

public class Hangar {

    public static Plane[] planesToSell = DataProvider.planeArray;
    public static Plane[] hangarPlanes = new Plane[0];
    public static Scanner input = new Scanner(System.in);

    public static void hangar() {
        System.out.println("\n" + """
                Welcome to the Plane purchase/Sell system. What would you like to do?
                1. Purchase a new plane.
                2. Sell a plane.
                3. List all the planes in your hangar.
                4. Sort planes by flight range.
                5. Calculate overall passenger capacity across all of your passenger planes.
                6. Calculate overall cargo capacity across all of your cargo planes.
                7. Search for a plane.
                8. Get the overall number of planes in the hangar.
                9. Exit the app.""");
        //menu();
        int userChoice = Reader.errorHandling(9, "Please enter a number 1-9");
        menu(userChoice);
    }

    public static void menu(int userChoice) {
        switch (userChoice) {
            case 1 -> PurchaseService.buyPlane();
            case 2 -> SellService.sellPlane();
            case 3 -> TotalOperationsServices.listPlanes();
            case 4 -> SortPlaneService.sortByFlight();
            case 5 -> TotalOperationsServices.totalPassCapacity();
            case 6 -> TotalOperationsServices.totalCargoCapacity();
            case 7 -> SearchManager.searchPlane();
            case 8 -> TotalOperationsServices.totalAmountOfPlanes();
            case 9 -> exit();
        }
        /*int userInput = input.nextInt();
        Reader.errorHandling(userInput, 9, "You didn't type a number! Please enter a number 1-9");
        input.nextLine();*/
        /*try {
            int userInput = input.nextInt();
            System.out.println();
            switch (userInput) {
                case 1 -> PurchaseService.buyPlane();
                case 2 -> SellService.sellPlane();
                case 3 -> listPlanes();
                case 4 -> SortPlaneService.sortByFlight();
                case 5 -> TotalCalculationsService.totalPassCapacity();
                case 6 -> TotalCalculationsService.totalCargoCapacity();
                case 7 -> SearchManager.searchPlane();
                case 8 -> TotalCalculationsService.totalAmountOfPlanes();
                case 9 -> exit();
                default -> System.out.println("Please enter a number 1-9");
            }
        } catch (Exception e) {
            System.out.println("You didn't type a number! Please enter a number 1-9");
            input.nextLine(); // required to clear the invalid input
        }*/
    }

    public static void exit() {
        System.exit(0);
    }
}
