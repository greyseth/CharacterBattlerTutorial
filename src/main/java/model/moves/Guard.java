package model.moves;

import model.Character;
import model.Move;

public class Guard extends Move {
    public Guard(String name, int mpCost) {
        super(name, mpCost);
    }

    @Override
    public void onAction(Character player, Character target) {
        super.onAction(player, target);

        player.prevDef = player.def;
        player.def += (int) (player.def*.8);
        System.out.println("GUARDING! (DEF: "+player.def+")");

        player.guarding = true;
    }

    @Override
    public void afterAction(Character player, Character target) {

    }
}
