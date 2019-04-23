package dnd.core;

import dnd.api.ContentStore;
import dnd.api.Monster;
import dnd.api.Treasure;
import dnd.api.Weapon;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tobias on 09.07.16.
 */
public class ContentStoreImpl implements ContentStore {
    Map<String, Weapon> weapons;
    Map<String, Monster> monsters;
    Map<String, Treasure> treasures;

    public ContentStoreImpl() {
        this.weapons = new HashMap<String, Weapon>();
        this.monsters = new HashMap<String, Monster>();
        this.treasures = new HashMap<String, Treasure>();
    }


    public void addMonster(Monster monster) {
        this.monsters.put(monster.getName(), monster);
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.put(weapon.getName(), weapon);
    }

    public void addTreasure(Treasure treasure) {
        this.treasures.put(treasure.getName(), treasure);
    }

    public Map<String, Weapon> getWeapons() {
        return this.weapons;
    }

    public Map<String, Monster> getMonsters() {
        return this.monsters;
    }

    public Map<String, Treasure> getTreasures() {
        return this.treasures;
    }
}
