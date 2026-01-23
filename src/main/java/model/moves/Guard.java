package model.moves;

import model.Move;

public class Guard extends Move {
    public Guard(String name, int mpCost) {
        super(name, mpCost);
    }

    @Override
    public void onAction() {
        // increase defense
    }
}
