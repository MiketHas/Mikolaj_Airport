package org.example.service;

import org.example.util.Hangar;

public class Reader {

    public static int errorHandling(int maxValue, String message) {
        while (true) {
            try {
                int userInput = Hangar.input.nextInt();
                if (userInput <= maxValue && userInput > 0) {
                    return userInput;
                }
            } catch (Exception e) {
                System.out.println("Exception! " + message);
                Hangar.input.nextLine();
            }
        }
    }

    public static int searchErrorHandling(String message) {
        while (true) {
            try {
                return Hangar.input.nextInt();
            } catch (Exception e) {
                System.out.println("Exception! " + message);
                Hangar.input.nextLine();
            }
        }
    }
}
