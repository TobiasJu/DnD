package parser;

import dnd.api.ContentStore;
import dnd.core.ContentStoreImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tobias on 09.07.16.
 */
public class WeaponParserTest {
    private ContentStore contentStore = new ContentStoreImpl();
    private TreasureParser treasureParser = new TreasureParser(this.contentStore);
    private WeaponParser weaponParser = new WeaponParser(this.contentStore);
    private CreatureParser creatureParser = new CreatureParser(this.contentStore);
    private RoomParser roomParser = new RoomParser(this.contentStore);

    @Test
    public void testParsing(){
        weaponParser.parse("weapons.txt");
        assertEquals(6, this.contentStore.getWeapons().keySet().size());
        treasureParser.parse("gold.txt");
        creatureParser.parse("creatures.txt");
        roomParser.parse("rooms.txt");
    }

}