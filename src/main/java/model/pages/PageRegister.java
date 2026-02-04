package model.pages;

import model.Page;
import model.Character;
import model.PageManager;
import util.SaveManager;

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

        System.out.println("Set stats for your character (12 stat points max)");

        int points = 12;
        int agiInput = 0;
        int defInput = 0;
        int strInput = 0;

        System.out.println("Enter str: (points remaining: "+points+")");
        strInput = inputNumber(10);

        points -= strInput;

        boolean defInputValid = false;
        while(!defInputValid) {
            System.out.println("Enter def: (points remaining: "+points+")");
            defInput = inputNumber(10);

            if (defInput > points) System.out.println("Insufficient points! (Points remaining: "+points+")");
            else {
                defInputValid = true;
                points -= defInput;
            }
        }

        boolean agiInputValid = false;
        while(!agiInputValid) {
            System.out.println("Enter agi: (points remaining: "+points+")");
            agiInput = inputNumber(10);

            if (agiInput > points) System.out.println("Insufficient points! (Points remaining: "+points+")");
            else {
                agiInputValid = true;
                points -= agiInput;
            }
        }

        Character newCharacter = new Character(nameInput, agiInput, defInput, strInput);
        System.out.println("New character created! - "+newCharacter.name);

        characters.add(newCharacter);

        SaveManager.saveData();
        PageManager.currentPage = "character_list";
    }
}
