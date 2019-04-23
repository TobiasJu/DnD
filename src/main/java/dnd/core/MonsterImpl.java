package dnd.core;

import dnd.api.Monster;
import dnd.api.Weapon;
import dnd.tools.damageTools.DamageCalculator;

/**
 * Created by marius on 27.06.16.
 * @version 0.1
 */
public class MonsterImpl implements Monster {

    double health;
    int experience;
    Weapon weapon;
    String name;
    String description;
    DamageCalculator dmgCalculator;

    //Use setter methods
    public MonsterImpl(double health, int experience, Weapon weapon, String name, String description) {
        this.health = health;
        this.experience = experience;
        this.weapon = weapon;
        this.name = name;
        this.dmgCalculator = new DamageCalculator();
        this.description = description;
    }

    public double getDamage() {
        return this.dmgCalculator.calcDamage(this.experience, this.weapon.getDamage());
    }

    public double getHealth() {
        return this.health;
    }

    public boolean decreaseHealth(double damage) {
        if((this.health - damage) <= 0) {
            this.health = 0;
            return true;
        } else {
            this.health = this.health - damage;
            return false;
        }
    }

    public int getExperience() {
        return this.experience;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }
}