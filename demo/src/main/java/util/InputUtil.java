package util;

import java.util.Scanner;
public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}

