package util;

import java.util.Scanner;

public class UserInputHandler {
    public static String getString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n>> ");
        return scanner.nextLine();
    }

    public static String getString(String msg) {
        System.out.print(msg);
        return getString();
    }

    public static int getInt() {
        int input = 0;
        try {
            input = Integer.parseInt(getString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static int getInt(String msg) {
        System.out.print(msg);
        return getInt();
    }
}
