package model.moves;

import model.Character;
import model.Move;

import java.util.Random;

public class LightAttack extends Move {
    public LightAttack(String name, int mpCost) {
        super(name, mpCost);
    }

    @Override
    public void onAction(Character player, Character target) {
        super.onAction(player, target);

        // .5 + (a.agi / (a.agi+b.agi)) * .5 (basic hit rate formula)
        // a.atk * 4 - b.def * 2 (basic attack formula)

        double hitRate = .5 + ((double) player.agi / (player.agi + target.agi)) * .5;

        Random random = new Random();
        int hitNumber = random.nextInt(1, 100);
        if (hitNumber < hitRate*100) {
            double damage = player.str * 4 - target.def * 2;
            if (damage <= 0) damage = 2;
            target.hp -= damage;
            System.out.println("ATTACK HITS! -"+damage+" HP");
        }else System.out.println("ATTACK MISSED!");
    }
}
