package model;

public class Move {
    public String name;
    public int mpCost;

    public Move(String name, int mpCost) {
        this.name = name;
        this.mpCost = mpCost;
    }

    public void onAction(Character player, Character target) {
        if (player.mp < mpCost) {
            System.out.println("NOT ENOUGH MP!");
            return;
        }

        player.mp -= mpCost;
    }

    public void afterAction(Character player, Character target) {

    }
}
