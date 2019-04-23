package dnd.tools.damageTools;

import dnd.tools.dice.Dice;
import dnd.tools.dice.DiceImpl;

/**
 * Created by marius on 27.06.16.
 */
public class DamageCalculator {

    private Dice dice = new DiceImpl(20);

    public DamageCalculator() {

    }

    public double calcDamage(int experience, double weaponStrength) {
        double damage = experience*weaponStrength + dice.diceRoll();
        return damage;
    }
}