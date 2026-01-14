package model.pages;

import model.Page;
import model.PageManager;

import java.util.ArrayList;

public class PageMain extends Page {
    public PageMain(String name, String initialText, ArrayList<String> menus) {
        super(name, initialText, menus);
    }

    @Override
    public void onInput(int input) {
        if (input == 1) {
            PageManager.currentPage = "character_list";
        }else if (input == 2) {
            System.out.println("Battling!!!!!!");
        }else {
            PageManager.applicationRunning = false;
        }
    }
}
