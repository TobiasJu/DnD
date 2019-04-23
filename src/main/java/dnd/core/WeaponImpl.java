package dnd.core;

import dnd.api.Weapon;

/**
 * Created by Tobias on 05.07.16.
 * @version 1.0
 */
public class WeaponImpl implements Weapon {

    final double damage;
    final String description;
    final String name;

    public WeaponImpl(Double damage, String description, String name) {
        this.damage = damage;
        this.description = description;
        this.name = name;
    }


    public double getDamage() {
        return this.damage;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
