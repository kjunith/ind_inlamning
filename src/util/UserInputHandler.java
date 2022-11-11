package util;

import java.util.Scanner;

public class UserInputHandler {

    /**
     * Prints an input indicator and returns input
     * as String
     *
     * @return input
     */
    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n>> ");
        return scanner.nextLine();
    }

    /**
     * Prints a message before printing an input
     * indicator and returns input as String
     *
     * @return input
     */
    public static String getString(String msg) {
        System.out.print(msg);
        return getString();
    }

    /**
     * Prints an input indicator and returns input
     * as Integer
     *
     * @return input
     */
    public static int getInt() {
        int input = 0;
        try {
            input = Integer.parseInt(getString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return input;
    }

    /**
     * Prints a message before printing an input
     * indicator and returns input as Integer
     *
     * @return input
     */
    public static int getInt(String msg) {
        System.out.print(msg);
        return getInt();
    }
}
