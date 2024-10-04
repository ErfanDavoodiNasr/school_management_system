package util;

import java.util.Scanner;

public class Help {
    private static Scanner scanner = new Scanner(System.in);

    public static Integer intInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next(); // Clear the invalid input
        }
        Integer number = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character
        return number;
    }

    public static String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void print(String prompt) {
        System.out.print(prompt);
    }

    public static void println(String prompt) {
        System.out.println(prompt);
    }
}
