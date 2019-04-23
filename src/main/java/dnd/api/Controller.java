package dnd.api;

import dnd.tools.directions.Directions;

import java.util.List;

/**
 * Created by marius on 04.07.16.
 */
interface Controller {
    List<Directions> getDirections();
    void fight();
    void collect();
    void flee();


}