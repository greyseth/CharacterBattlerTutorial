package model.pages;

import model.*;
import model.Character;
import util.Input;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PageBattle extends Page {
    public PageBattle(String name, String initialText, ArrayList<String> menus) {
        super(name, initialText, menus);
    }

    @Override
    public void pageRun() {
        if (CharacterManager.characters.isEmpty()) {
            System.out.println("You haven't registered any characters");
            PageManager.currentPage = "main_menu";
            return;
        }

        System.out.println("Select your character:");
        for (int i = 0; i < CharacterManager.characters.size(); i++) {
            System.out.println(i+1+ " - "+CharacterManager.characters.get(i).name);
        }
        System.out.println(CharacterManager.characters.size()+1+" - Back");

        int characterinput = Input.inputNumber(CharacterManager.characters.size()+1);
        if (characterinput == CharacterManager.characters.size()+1) {
            PageManager.currentPage = "main_menu";
            return;
        }

        String[] FIRST_NAMES = {
                "Alex", "Jordan", "Taylor", "Morgan", "Riley",
                "Sam", "Casey", "Jamie", "Avery", "Quinn"
        };

        String[] LAST_NAMES = {
                "Smith", "Johnson", "Williams", "Brown", "Davis",
                "Miller", "Wilson", "Moore", "Taylor", "Anderson"
        };

        Random random = new Random();

        int enemyPoints = 12;
        int enemyStr = random.nextInt(1, enemyPoints);
        enemyPoints -= enemyStr;

        int enemyDef = random.nextInt(1, enemyPoints);
        enemyPoints -= enemyDef;

        int enemyAgi = enemyPoints;

        String firstName = FIRST_NAMES[random.nextInt(0, FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(0, LAST_NAMES.length)];


        Character player = CharacterManager.characters.get(characterinput-1);
        Character enemy = new Character(firstName+" "+lastName, enemyAgi, enemyDef, enemyStr);

        System.out.println("You're fighting "+enemy.name+"!");
        System.out.printf("(HP:%1$s|MP:%2$s)\n[STR:%3$s|DEF:%4$s|AGI:%5$s]", enemy.hp, enemy.mp, enemy.str, enemy.def, enemy.agi);
        System.out.println("");

        boolean playerTurn = true;
        boolean isBattling = true;
        while(isBattling) {
            int moveInput = 0;

            if (playerTurn) {
                System.out.println("--Your Turn!--");
                for (int i = 0; i < CharacterManager.moves.size(); i++) {
                    System.out.println((i+1)+" - "+CharacterManager.moves.get(i).name + " | "+CharacterManager.moves.get(i).mpCost+" MP");
                }

                moveInput = Input.inputNumber(CharacterManager.moves.size());
            }else {
                System.out.println("--"+enemy.name+"'s Turn!--");

                moveInput = random.nextInt(1, CharacterManager.moves.size()+1);
            }

            Move selectedMove = CharacterManager.moves.get(moveInput-1);
            System.out.println((playerTurn ? player : enemy).name+" performs "+selectedMove.name);
            selectedMove.onAction();

            playerTurn = !playerTurn;
        }
    }
}
