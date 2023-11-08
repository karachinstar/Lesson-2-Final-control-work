package model;

import java.util.Collection;
import java.util.List;

public class CollectionsCommands {
    public static Collection<String> getCollections(String commands) {
        return List.of(commands.replaceAll(" ", "").split(","));
    }
}
