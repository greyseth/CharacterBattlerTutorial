package util;

import java.util.Scanner;

public class Input {
    public static int inputNumber(int optionCount) {
        Scanner scanner = new Scanner(System.in);

        int inputNumber = 0;

        boolean isValid = false;
        while(!isValid) {
            try {
                String rawInput = scanner.nextLine();

                inputNumber = Integer.parseInt(rawInput);
                if (inputNumber > 0 && inputNumber <= optionCount) {
                    isValid = true;
                } else {
                    System.out.println("Invalid menu input");
                }
            } catch (Exception e) {
                System.out.println("Input must be a number");
            }
        }

        return inputNumber;
    }
}
