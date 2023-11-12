package model;

import java.io.IOException;
import java.util.HashMap;

public interface Registry {
    String addNewPet(HashMap<Enum<FieldAnimal>, String> data) throws IOException;
    String getCommandsPet(String name);
    String addNewCommand(HashMap<Enum<FieldAnimal>, String> newCommands);
    String getPetsByBirthday(String birthday);
    String getAll();
    String getAllName();

}
