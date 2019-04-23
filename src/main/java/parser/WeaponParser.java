package parser;

import dnd.api.ContentStore;
import dnd.api.Weapon;
import dnd.core.WeaponImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tobias on 09.07.16.
 * @version 1.0rc
 */
public class WeaponParser extends AbstractParser {
    Map<String, String> properties;
    List<Weapon> weaponList;
    ContentStore contentStore;

    public WeaponParser(ContentStore contentStore) {
        this.contentStore = contentStore;
        this.properties = new HashMap<String, String>();
    }

    public void handleLine(String line) {
        if(line.startsWith("Name")) {
            this.properties.put("Name", line.replace("Name: ", ""));
        } else if (line.startsWith("Force")) {
            this.properties.put("Force", line.replace("Force: ", ""));
        } else if(line.startsWith("Description")) {
            this.properties.put("Description", line.replace("Description: ", ""));
        } else{
            makeNewWeapon(this.properties);
            properties = new HashMap<String, String>();
        }

    }

    public void makeNewWeapon(Map<String, String> properties) {
        //TODO: Implement Weaponparser and Weaponstore
        Weapon weapon = new WeaponImpl(Double.parseDouble(properties.get("Force")), properties.get("Description"), properties.get("Name"));
        this.contentStore.addWeapon(weapon);
    }
}
