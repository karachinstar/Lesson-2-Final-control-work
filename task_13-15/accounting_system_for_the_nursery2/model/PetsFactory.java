package model;

import model.animals.*;

import java.util.Collection;
import java.util.HashMap;

public class PetsFactory {
    private HashMap<Enum<FieldAnimal>, String> data;
    private Collection<String> arrayCommand;

    public Pet detAnimal(HashMap<Enum<FieldAnimal>, String> data) {
        Pet pet = null;
        this.data = data;
        setArrayCommand();
        switch (data.get(FieldAnimal.TYPE)) {
            case "dog" -> pet = setDog();
            case "cat" -> pet = setCat();
            case "hamster" -> pet = setHamster();
        }
        return pet;
    }

    private Dog setDog() {
        Dog dog = new Dog(data.get(FieldAnimal.NAME));
        dog.setBirthDate(data.get(FieldAnimal.BIRTHDATE));
        dog.addCommands(arrayCommand);
        return dog;
    }

    private Cat setCat() {
        Cat cat = new Cat(data.get(FieldAnimal.NAME));
        cat.setBirthDate(data.get(FieldAnimal.BIRTHDATE));
        cat.addCommands(arrayCommand);
        return cat;
    }

    private Hamster setHamster() {
        Hamster hamster = new Hamster(data.get(FieldAnimal.NAME));
        hamster.setBirthDate(data.get(FieldAnimal.BIRTHDATE));
        hamster.addCommands(arrayCommand);
        return hamster;
    }

    private void setArrayCommand() {
        arrayCommand = CollectionsCommands.getCollections(data.get(FieldAnimal.COMMAND));
    }
}
