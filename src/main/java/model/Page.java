package model;

import java.util.ArrayList;

public class Page {
    public String name;
    public String initialText;
    public ArrayList<String> menus;

    public Page(String name, String initialText, ArrayList<String> menus) {
        this.name = name;
        this.initialText = initialText;
        this.menus = menus;
    }

    public void pageRun() {

    }

    public void onInput(int input) {

    }
}
