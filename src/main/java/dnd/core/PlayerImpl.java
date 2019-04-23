package dnd.core;

import dnd.api.Player;
import dnd.api.Weapon;

/**
 * Created by Tobias on 05.07.16.
 */
public class PlayerImpl implements Player {
    int experience;
    double health;
    Weapon weapon;

    public PlayerImpl(int experience, double health, Weapon weapon) {
        this.experience = experience;
        this.health = health;
        this.weapon = weapon;
    }


    public int getExperience() {
        return this.experience;
    }

    public double getHealth() {
        return this.health;
    }

    public boolean getDamage(double damage) {
        if((this.health - damage) <= 0) {
            this.health = 0;
            return true;
        } else {
            this.health = this.health - damage;
            return false;
        }
    }

    public Weapon getWeapon() {
        return null;
    }

    public void setNewWeapon(Weapon weapon) {

    }
}
