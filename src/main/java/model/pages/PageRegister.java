package model.pages;

import model.Page;
import model.Character;
import model.PageManager;

import java.util.ArrayList;
import java.util.Scanner;

import static model.CharacterManager.characters;
import static util.Input.inputNumber;

public class PageRegister extends Page {
    public PageRegister(String name, String initialText, ArrayList<String> menus) {
        super(name, initialText, menus);
    }

    @Override
    public void pageRun() {
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

        PageManager.currentPage = "character_list";
    }
}
