package repository;

import model.FieldAnimal;
import model.animals.Pet;

import java.util.Collection;
import java.util.HashMap;


public interface Database {
    void addNewAnimal(Pet pet);
    Collection<String> getCommandsPet(String name);
    void addNewCommand(HashMap<Enum<FieldAnimal>, String> newCommands);
    Collection<Pet>getPetsByBirthday(String birthday);
     Collection<Pet>getAll();
}