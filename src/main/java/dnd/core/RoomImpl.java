package dnd.core;

import dnd.api.Room;
import dnd.tools.directions.Directions;
import dnd.tools.various.ContentType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tobias on 09.07.16.
 */
public class RoomImpl implements Room {
    Map<Directions, Room> neighbours = new HashMap<Directions, Room>();
    Map<Directions, String> neighbourNames = new HashMap<Directions, String>();
    ContentType contentType = ContentType.Nothing;
    String description;
    String name;
    Object content;

    public RoomImpl(String name, String description) {
        this.description = description;
        this.name = name;

    }

    public Map<Directions, Room> getNeighbours() {
        return this.neighbours;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Object getContent() {
        return this.content;
    }

    public void setNeighbours(Directions direction, Room room) {
        neighbours.put(direction, room);
    }

    public Map<Directions, String> getNeighbourNames() {
        return this.neighbourNames;
    }

    public void setNeighbourNames(Map<Directions, String> neighbourNames) {
        this.neighbourNames = neighbourNames;
    }

    public void setContentType(ContentType type) {
        this.contentType = type;
    }

    public void setContent(Object content) {
        this.content = content;
    }


}
