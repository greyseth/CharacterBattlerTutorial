import com.sun.security.jgss.GSSUtil;
import model.Character;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to CharacterBattler");

        ArrayList<Character> characters = new ArrayList();

        boolean running = true;
        while(running) {
            System.out.println("1 - Character List");
            System.out.println("2 - Battle");
            System.out.println("3 - Exit");

            int userInput = 0;
            userInput = inputNumber(3);
            System.out.println(userInput);

            if (userInput == 1) {
                System.out.println("Characters registered: "+characters.size());
                for (int i = 0; i < characters.size(); i++) {
                    System.out.println(characters.get(i).name);
                }

                System.out.println("1 - Register New Character");
                System.out.println("2 - Back");

                int userInput2 = inputNumber(2);

                if (userInput2 == 1) {
                    System.out.println("Register a new character");
                    System.out.println("Enter name: ");

                    Scanner scanner = new Scanner(System.in);
                    String nameInput = scanner.nextLine();

                    System.out.println("Enter agi:");
                    int agiInput = inputNumber(12);

                    System.out.println("Enter def:");
                    int defInput = inputNumber(12);

                    System.out.println("Enter str:");
                    int strInput = inputNumber(12);

                    Character newCharacter = new Character(nameInput, agiInput, defInput, strInput);
                    System.out.println("New character created! - "+newCharacter.name);

                    characters.add(newCharacter);
                }
            } else if (userInput == 2) {
                System.out.println("Battle menu");
            } else {
                System.out.println("Goodbye");
                running = false;
            }
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
