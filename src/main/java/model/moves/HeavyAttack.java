package model.moves;

import model.Move;

public class HeavyAttack extends Move {
    public HeavyAttack(String name, int mpCost) {
        super(name, mpCost);
    }

    @Override
    public void onAction() {
        // deal heavy damage
    }
}
