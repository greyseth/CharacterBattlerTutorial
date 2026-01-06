import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to CharacterBattler");

        System.out.println("1 - Character List");
        System.out.println("2 - Battle");
        System.out.println("3 - Exit");

        String userInput = "";

        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();

        if (userInput.equals("1")) {
            System.out.println("Character List Menu");
        }else if (userInput.equals("2")) {
            System.out.println("Battle menu");
        }else {
            System.out.println("Goodbye");
        }
    }
}
