package parser;

import dnd.api.ContentStore;
import dnd.api.Monster;
import dnd.api.Weapon;
import dnd.core.MonsterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marius on 27.06.16.
 * @version 1.0rc
 */
public class CreatureParser extends AbstractParser{
    Map<String, String> properties;
    List<Monster> monsterList;
    ContentStore contentStore;
    public CreatureParser(ContentStore contentStore) {
        this.properties = new HashMap<String, String>();
        this.monsterList = new ArrayList<Monster>();
        this.contentStore = contentStore;
        if (contentStore.getWeapons().isEmpty()) {
            new WeaponParser(this.contentStore).parse("weapons.txt");
        }
    }

    public void handleLine(String line) {
        if(line.startsWith("Name")) {
            this.properties.put("Name", line.replace("Name: ", ""));
        } else if (line.startsWith("Species")) {
            this.properties.put("Species", line.replace("Species: ", ""));
        } else if(line.startsWith("Description")) {
            this.properties.put("Description", line.replace("Description: ", ""));
        } else if (line.startsWith("Experience")) {
            this.properties.put("Experience", line.replace("Experience: ", ""));
        } else if (line.startsWith("HealthStatus")) {
            this.properties.put("HealthStatus", line.replace("HealthStatus: ", ""));
        } else if (line.startsWith("Weapon")) {
            this.properties.put("Weapon", line.replace("Weapon: ", ""));
        } else{
            makeNewCreature(this.properties);
            this.properties = new HashMap<String, String>();

        }

    }

    public void makeNewCreature(Map<String, String> properties) {
        Double health = Double.parseDouble(properties.get("HealthStatus"));
        Integer experience = Integer.parseInt(properties.get("Experience"));
        Weapon weapon = this.contentStore.getWeapons().get(properties.get("Weapon"));
        String name = properties.get("Name");
        String description = properties.get("Description");
        Monster monster = new MonsterImpl(health, experience, weapon, name, description);
        this.contentStore.getMonsters().put(monster.getName(), monster);
    }

}
