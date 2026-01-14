package model.pages;

import model.CharacterManager;
import model.Page;
import model.PageManager;

import java.util.ArrayList;

public class PageCharacterList extends Page {
    public PageCharacterList(String name, String initialText, ArrayList<String> menus) {
        super(name, initialText, menus);
    }

    @Override
    public void pageRun() {
        System.out.println("Characters registered: "+ CharacterManager.characters.size());
        for (int i = 0; i < CharacterManager.characters.size(); i++) {
            System.out.println(CharacterManager.characters.get(i).name);
        }
    }

    @Override
    public void onInput(int input) {
        if (input == 1) {
            PageManager.currentPage = "register";
        }else {
            PageManager.currentPage = "main_menu";
        }
    }
}
