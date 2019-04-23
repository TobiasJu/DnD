package dnd.core;

import dnd.api.Treasure;

/**
 * Created by Tobias on 14.07.2016.
 */
public class TreasureImpl implements Treasure{
    String name;
    String description;
    public TreasureImpl(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
