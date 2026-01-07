import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to CharacterBattler");

        System.out.println("1 - Character List");
        System.out.println("2 - Battle");
        System.out.println("3 - Exit");

        int userInput = 0;
        userInput = inputNumber(3);
        System.out.println(userInput);

        if (userInput == 1) {
            System.out.println("Characters registered: 0");
            System.out.println("1 - Register New Character");
            System.out.println("2 - Back");

            int userInput2 = inputNumber(2);

            System.out.println("CHaracter list");
        }else if (userInput == 2) {
            System.out.println("Battle menu");
        }else {
            System.out.println("Goodbye");
        }
    }

    static int inputNumber(int optionCount) {
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
