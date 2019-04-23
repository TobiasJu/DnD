package dnd.core;

import dnd.api.ContentStore;
import dnd.api.Gameboard;
import dnd.api.Room;
import dnd.tools.directions.Directions;
import dnd.tools.various.ContentType;
import dnd.tools.various.DungeonBuilder;
import parser.RoomParser;

import java.util.Map;

/**
 * Created by Tobias on 09.07.16.
 */
public class GameboardImpl implements Gameboard{
    ContentStore contentStore = new ContentStoreImpl();
    Map<String, Room> dungeon;
    Room currentRoom;


    public GameboardImpl() {
        DungeonBuilder builder = new DungeonBuilder();
        this.dungeon = builder.makeDungeon(createRooms());
        this.currentRoom = this.dungeon.get("Entry");
    }

    public ContentStore getContentStore() {
        return this.contentStore;
    }

    public boolean enterNextRoom(Directions direction) {
        this.currentRoom = this.currentRoom.getNeighbours().get(direction);
        return true;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public ContentType getContentType() {
        return null;
    }

    private Map<String, Room> createRooms() {
        RoomParser parser = new RoomParser(this.contentStore);
        parser.parse("rooms.txt");
        return parser.getRooms();
    }
}
