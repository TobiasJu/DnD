package parser;

import dnd.api.*;
import dnd.core.RoomImpl;
import dnd.tools.directions.Directions;
import dnd.tools.various.ContentType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tobias on 09.07.16.
 * @version 1.0rc
 */
public class RoomParser extends AbstractParser {
    Map<String, String> properties = new HashMap<String, String>();
    Map<Directions, String> neighbourNames = new HashMap<Directions, String>();
    Map<String, Room> rooms = new HashMap<String, Room>();
    ContentStore contentStore;

    public RoomParser(ContentStore contentStore) {
        this.contentStore = contentStore;
        if(this.contentStore.getMonsters().isEmpty()){
            new CreatureParser(this.contentStore).parse("creatures.txt");

        }
        if(this.contentStore.getTreasures().isEmpty()) {
            new TreasureParser(this.contentStore).parse("gold.txt");
        }
    }



    @Override
    public void handleLine(String line) {
        if(line.startsWith("Name")) {
            properties.put("Name", line.replace("Name: ", ""));
        } else if (line.startsWith("N")) {
            this.neighbourNames.put(Directions.N, line.replace("N: ", ""));
        } else if (line.startsWith("S")) {
            this.neighbourNames.put(Directions.S, line.replace("S: ", ""));
        } else if (line.startsWith("W")) {
            this.neighbourNames.put(Directions.W, line.replace("W: ", ""));
        }else if (line.startsWith("O")) {
            this.neighbourNames.put(Directions.E, line.replace("O: ", ""));
        }else if (line.startsWith("Description")) {
            properties.put("Description", line.replace("Description: ", ""));
        } else if (line.startsWith("Content")) {
            properties.put("Content", line.replace("Content: ", ""));
        } else {
            createRoom();
            this.properties = new HashMap<String, String>();
            this.neighbourNames = new HashMap<Directions, String>();
        }
    }

    public void createRoom() {
        Room room = new RoomImpl(this.properties.get("Name"), this.properties.get("Description"));
        room.setNeighbourNames(this.neighbourNames);
        String content = this.properties.get("Content");
        if (this.contentStore.getWeapons().get(content) != null) {
            Weapon weapon = this.contentStore.getWeapons().get(content);
            room.setContentType(ContentType.Weapon);
            room.setContent(weapon);
        } else if (this.contentStore.getMonsters().get(content) != null) {
            Monster monster = this.contentStore.getMonsters().get(content);
            room.setContentType(ContentType.Monster);
            room.setContent(monster);
        } else if (this.contentStore.getTreasures().get(content) != null) {
            Treasure treasure = this.contentStore.getTreasures().get(content);
            room.setContentType(ContentType.Treasure);
            room.setContent(treasure);
        }
        else if (content.equals("none")) {
            room.setContentType(ContentType.Nothing);
        } else {
            throw new IllegalArgumentException(content);
        }

        rooms.put(room.getName(), room);
    }

    public Map<String, Room> getRooms() {
        return this.rooms;
    }
}
