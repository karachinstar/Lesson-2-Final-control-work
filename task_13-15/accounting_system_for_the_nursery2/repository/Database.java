package repository;

import model.FieldAnimal;
import model.animals.Pet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;


public interface Database {
    void addNewAnimal(Pet pet) throws IOException;
    Collection<String> getCommandsPet(String name);
    void addNewCommand(HashMap<Enum<FieldAnimal>, String> newCommands);
    Collection<Pet>getPetsByBirthday(String birthday);
     Collection<Pet>getAll();
}