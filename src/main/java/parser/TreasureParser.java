package parser;

import dnd.api.ContentStore;

import dnd.api.Treasure;
import dnd.core.TreasureImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tobias on 14.07.2016.
 * @version 1.0rc
 */
public class TreasureParser extends AbstractParser{
    Map<String, String> properties;
    ContentStore contentStore;

    public TreasureParser(ContentStore contentStore) {
        this.properties = new HashMap<String, String>();
        this.contentStore = contentStore;
    }
    @Override
    public void handleLine(String line) {
        if (line.startsWith("Name")) {
            this.properties.put("name", line.replace("Name: ", ""));
        } else if (line.startsWith("Description")) {
            this.properties.put("description", line.replace("Description: ", ""));
        } else {
            createTreasure();
            this.properties = new HashMap<String, String>();
        }
    }

    public void createTreasure() {
        Treasure treasure = new TreasureImpl(this.properties.get("name"), this.properties.get("description"));
        this.contentStore.addTreasure(treasure);
    }
}
