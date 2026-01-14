import com.sun.security.jgss.GSSUtil;
import model.Character;
import model.CharacterManager;
import model.Page;
import model.PageManager;
import model.pages.PageCharacterList;
import model.pages.PageMain;
import model.pages.PageRegister;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Scanner;

import static util.Input.inputNumber;

public class App {
    public static void main(String[] args) {
        ArrayList<String> mainMenuMenus = new ArrayList<>();
        mainMenuMenus.add("Character List");
        mainMenuMenus.add("Battle");
        mainMenuMenus.add("Exit");

        ArrayList<String> characterListMenus = new ArrayList<>();
        characterListMenus.add("Register New Character");
        characterListMenus.add("Back");

        Page mainMenu = new PageMain("main_menu", "Welcome to CharacterBattler!", mainMenuMenus);
        Page characterList = new PageCharacterList("character_list", "", characterListMenus);
        Page register = new PageRegister("register", "--Register a new character--", new ArrayList<>());

        ArrayList<Page> pages = new ArrayList<>();
        pages.add(mainMenu);
        pages.add(characterList);
        pages.add(register);

        while(PageManager.applicationRunning) {
            Page openPage = pages.stream().filter(p -> p.name.equals(PageManager.currentPage)).toList().getFirst();

            openPage.pageRun();

            System.out.println(openPage.initialText);
            for (int i = 0; i < openPage.menus.size(); i++) {
                System.out.println(i+1 + " - "+openPage.menus.get(i));
            }

            if (!openPage.menus.isEmpty()) {
                int userInput = inputNumber(openPage.menus.size());
                openPage.onInput(userInput);
            }
        }
    }
}
