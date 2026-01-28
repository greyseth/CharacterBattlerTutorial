package model;

public class Character {
    public String name;
    public int hp = 100;
    public int mp = 50;
    public int agi;
    public int def;
    public int str;

    public Character(String name, int agi, int def, int str) {
        this.name = name;
        this.agi = agi;
        this.def = def;
        this.str = str;
    }
}
