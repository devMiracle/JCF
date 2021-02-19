package net.miracle.community;

import java.util.Scanner;

public class ConsoleController {
    public static Integer inputInteger(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();
        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }
        return null;
    }
    private static Boolean isNumeric(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException error) {
            return false;
        }
    }
}
