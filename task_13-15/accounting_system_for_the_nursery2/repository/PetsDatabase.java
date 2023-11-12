package repository;


import java.io.*;

import model.CollectionsCommands;
import model.FieldAnimal;
import model.PetsFactory;
import model.animals.Pet;

import java.util.*;

import static repository.СreateIfNotExists.createIfNotExists;


public class PetsDatabase implements Database {
    private Collection<Pet> petCollection = new ArrayList<>();
    public PetsDatabase() throws IOException {
        setPetsAnimalCollection();
    }

    // 9.1. Добавление нового животного
    @Override
    public void addNewAnimal(Pet pet) throws IOException {
        petCollection.add(pet);


    }

    // 9.2. Список команд животного
    @Override
    public Collection<String> getCommandsPet(String name) {
        Collection<String> temp = null;
        for (Pet p : petCollection) {
            if (p.getName().equals(name)) {
                temp = p.getCommands();
            }
        }
        return temp;
    }

    //9.3. Обучение новым командам
    @Override
    public void addNewCommand(HashMap<Enum<FieldAnimal>, String> newCommands) {
        for (Pet p : petCollection) {
            if (p.getName().equals(newCommands.get(FieldAnimal.NAME))) {
                p.addCommands(CollectionsCommands.getCollections(newCommands.get(FieldAnimal.COMMAND)));
            }
        }
    }

    // 9.4 Вывести список животных по дате рождения
    @Override
    public Collection<Pet> getPetsByBirthday(String birthday) {
        Collection<Pet> temp = new ArrayList<>();
        for (Pet p : petCollection) {
            if (p.getBirthDate().equals(birthday))
                temp.add(p);
        }
        return temp;
    }

    @Override
    public Collection<Pet> getAll() {
        return petCollection;
    }

    // Наполняем базу предварительными данными
    private void setPetsAnimalCollection() throws IOException {
        createIfNotExists("task_13-15/accounting_system_for_the_nursery2/database.json");
        PetsFactory factory = new PetsFactory();
        BufferedReader br = new BufferedReader(new FileReader("task_13-15/accounting_system_for_the_nursery2/database.json"));
        String line;
        HashMap<Enum<model.FieldAnimal>, String> hashMap = new HashMap<>();
        while ((line = br.readLine()) != null) {
            String charsToRemove = "{}\"";
            for (char c : charsToRemove.toCharArray()) {
                line = line.replace(String.valueOf(c), "");
            }
            String[] fields = line.split(":|,");
            for (int i = 0; i < fields.length - 1; i = i + 2) {
                if (fields[i].equals("TYPE")) {
                    hashMap.put(FieldAnimal.TYPE, fields[i + 1]);
                } else if (fields[i].equals("NAME")) {
                    hashMap.put(FieldAnimal.NAME, fields[i + 1]);
                } else if (fields[i].equals("BIRTHDATE")) {
                    hashMap.put(FieldAnimal.BIRTHDATE, fields[i + 1]);
                } else {
                    hashMap.put(FieldAnimal.COMMAND, fields[i + 1]);
                }
            }
            petCollection.add(factory.detAnimal(hashMap));
        }
    }
}














