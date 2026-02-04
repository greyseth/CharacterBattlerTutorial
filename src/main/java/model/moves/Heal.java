package model.moves;

import model.Character;
import model.Move;

public class Heal extends Move {
    public Heal(String name, int mpCost) {
        super(name, mpCost);
    }

    @Override
    public void onAction(Character player, Character target) {
        player.hp += 15;
    }
}
