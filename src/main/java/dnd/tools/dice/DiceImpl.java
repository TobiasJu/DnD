package dnd.tools.dice;

import java.util.Random;

/**
 * Created by marius on 27.06.16.
 * @version 1.0
 */
public class DiceImpl implements Dice{
    private Random rng;
    private int diceSides;

    public DiceImpl(int sides) {
        rng = new Random();
        this.diceSides = sides;
    }


    public double diceRoll() {
        int result = rng.nextInt(this.diceSides - 1) + 1;
        return result;
    }
}
