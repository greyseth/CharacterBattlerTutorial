package model;

import model.moves.Guard;
import model.moves.HeavyAttack;
import model.moves.LightAttack;

import java.util.ArrayList;

public class CharacterManager {
    public static ArrayList<Character> characters = new ArrayList<>();
    public static ArrayList<Move> moves = new ArrayList<>();

    public static void initializeMoves() {
        moves.add(new LightAttack("Light Attack", 0));
        moves.add(new HeavyAttack("Heavy Attack", 5));
        moves.add(new Guard("Guard", 7));
    }
}
