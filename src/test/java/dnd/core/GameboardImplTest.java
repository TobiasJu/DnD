package dnd.core;

import dnd.api.Gameboard;
import dnd.api.Weapon;
import dnd.tools.directions.Directions;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tobias on 12.07.16.
 */
public class GameboardImplTest {
    Gameboard gameboard = new GameboardImpl();

    @Test
    public void testGetContentStore() throws Exception {

    }

    @Test
    public void testEnterNextRoom() throws Exception {
        this.gameboard.enterNextRoom(Directions.N);
        assertEquals(this.gameboard.getCurrentRoom().getName(), "1-3");
        this.gameboard.enterNextRoom(Directions.N);
        Weapon weapon = (Weapon) this.gameboard.getCurrentRoom().getContent();
        System.out.println(weapon.getName());
        System.out.println(weapon.getDescription());
    }

    @Test
    public void testGetCurrentRoom() throws Exception {

    }

    @Test
    public void testGetContentType() throws Exception {

    }
}