package dnd.api;

import java.util.Map;

/**
 * Created by Tobias on 09.07.16.
 */
public interface ContentStore {
    Map<String, Weapon> getWeapons();
    Map<String, Monster> getMonsters();
    Map<String, Treasure> getTreasures();
    void addMonster(Monster monster);
    void addWeapon(Weapon weapon);
    void addTreasure(Treasure treasure);


}
