package dnd.api;

import dnd.tools.directions.Directions;
import dnd.tools.various.ContentType;

/**
 * Created by Tobias on 12.07.16.
 * @version 0.1
 */
public interface Gameboard {

    /**
     * Enters the next room which is in the direction handed over
     * @param direction Direction in which to move
     * @return true if entering is possible, false if it's not
     */
    boolean enterNextRoom(Directions direction);

    /**
     * Returns the current room the player is in.
     * @return current Room the player is in.
     */
    Room getCurrentRoom();


    /**
     * Returns the sort of stuff that is in the room.
     * @return
     */
    ContentType getContentType();

}
