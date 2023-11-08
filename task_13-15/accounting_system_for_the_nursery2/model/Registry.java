package model;

import java.util.HashMap;

public interface Registry {
    String addNewPet(HashMap<Enum<FieldAnimal>, String> data);
    String getCommandsPet(String name);
    String addNewCommand(HashMap<Enum<FieldAnimal>, String> newCommands);
    String getPetsByBirthday(String birthday);
    String getAll();
    String getAllName();

}
