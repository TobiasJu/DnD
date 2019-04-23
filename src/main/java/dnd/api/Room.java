package dnd.api;

import dnd.tools.directions.Directions;
import dnd.tools.various.ContentType;

import java.util.Map;

/**
 * Created by Tobias on 09.07.16.
 */
public interface Room {
    Map<Directions, Room> getNeighbours();
    ContentType getContentType();
    String getName();
    String getDescription();
    Object getContent();
    void setNeighbours(Directions direction, Room room);
    Map<Directions, String> getNeighbourNames();
    void setNeighbourNames(Map<Directions, String> neighbourNames);
    void setContentType(ContentType type);
    void setContent(Object content);
}
