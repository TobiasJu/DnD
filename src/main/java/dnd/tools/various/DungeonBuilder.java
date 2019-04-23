package dnd.tools.various;

import dnd.api.Room;
import dnd.tools.directions.Directions;

import java.util.List;
import java.util.Map;

/**
 * Created by Tobias on 09.07.16.
 */
public class DungeonBuilder {
    public Map<String, Room> makeDungeon(Map<String, Room> rooms) {
        Room room;
        for (String name : rooms.keySet()) {
            room = rooms.get(name);
            for (Directions dir : room.getNeighbourNames().keySet()) {
                String roomName = room.getNeighbourNames().get(dir);
                Room neighbourRoom = rooms.getOrDefault(roomName, null);
                if (neighbourRoom != null) {
                    room.setNeighbours(dir, neighbourRoom);
                }
            }
        }
        return rooms;
    }

}