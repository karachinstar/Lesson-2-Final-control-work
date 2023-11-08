

package repository;

import model.CollectionsCommands;
import model.FieldAnimal;
import model.PetsFactory;
import model.animals.Pet;


import java.util.*;

public class PetsDatabase implements Database {
    private final Collection<Pet> petCollection = new ArrayList<>();

    public PetsDatabase() {
        setPetsAnimalCollection();
    }

    // 9.1. Добавление нового животного
    @Override
    public void addNewAnimal(Pet pet) {
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
        public Collection<Pet> getPetsByBirthday (String birthday){
            Collection<Pet> temp = new ArrayList<>();
            for (Pet p : petCollection) {
                if (p.getBirthDate().equals(birthday))
                    temp.add(p);
                }
            return temp;
        }

        @Override
        public Collection<Pet> getAll () {
            return petCollection;
        }

        // Наполняем базу предварительными данными
        private void setPetsAnimalCollection () {
            PetsFactory factory = new PetsFactory();

            HashMap<Enum<FieldAnimal>, String> fido = new HashMap<>();
            fido.put(FieldAnimal.TYPE, "dog");
            fido.put(FieldAnimal.NAME, "Fido");
            fido.put(FieldAnimal.BIRTHDATE, "2020-01-01");
            fido.put(FieldAnimal.COMMAND, "Sit,Stay,Fetch");
            petCollection.add(factory.detAnimal(fido));

            HashMap<Enum<FieldAnimal>, String> bella = new HashMap<>();
            bella.put(FieldAnimal.TYPE, "dog");
            bella.put(FieldAnimal.NAME, "Bella");
            bella.put(FieldAnimal.BIRTHDATE, "2019-11-11");
            bella.put(FieldAnimal.COMMAND, "Sit,Stay,Roll");
            petCollection.add(factory.detAnimal(bella));

            HashMap<Enum<FieldAnimal>, String> buddy = new HashMap<>();
            buddy.put(FieldAnimal.TYPE, "dog");
            buddy.put(FieldAnimal.NAME, "Buddy");
            buddy.put(FieldAnimal.BIRTHDATE, "2018-12-10");
            buddy.put(FieldAnimal.COMMAND, "Sit,Paw,Bark");
            petCollection.add(factory.detAnimal(buddy));

            HashMap<Enum<FieldAnimal>, String> whiskers = new HashMap<>();
            whiskers.put(FieldAnimal.TYPE, "cat");
            whiskers.put(FieldAnimal.NAME, "Whiskers");
            whiskers.put(FieldAnimal.BIRTHDATE, "2019-05-15");
            whiskers.put(FieldAnimal.COMMAND, "Sit,Pounce");
            petCollection.add(factory.detAnimal(whiskers));

            HashMap<Enum<FieldAnimal>, String> oliver = new HashMap<>();
            oliver.put(FieldAnimal.TYPE, "cat");
            oliver.put(FieldAnimal.NAME, "Oliver");
            oliver.put(FieldAnimal.BIRTHDATE, "2020-06-30");
            oliver.put(FieldAnimal.COMMAND, "Meow,Scratch,Jump");
            petCollection.add(factory.detAnimal(oliver));

            HashMap<Enum<FieldAnimal>, String> smudge = new HashMap<>();
            smudge.put(FieldAnimal.TYPE, "cat");
            smudge.put(FieldAnimal.NAME, "Smudge");
            smudge.put(FieldAnimal.BIRTHDATE, "2020-02-20");
            smudge.put(FieldAnimal.COMMAND, "Scratch,Pounce");
            petCollection.add(factory.detAnimal(smudge));

            HashMap<Enum<FieldAnimal>, String> hammy = new HashMap<>();
            hammy.put(FieldAnimal.TYPE, "hamster");
            hammy.put(FieldAnimal.NAME, "Hammy");
            hammy.put(FieldAnimal.BIRTHDATE, "2021-03-10");
            hammy.put(FieldAnimal.COMMAND, "Roll,Hide");
            petCollection.add(factory.detAnimal(hammy));

            HashMap<Enum<FieldAnimal>, String> peanut = new HashMap<>();
            peanut.put(FieldAnimal.TYPE, "hamster");
            peanut.put(FieldAnimal.NAME, "Peanut");
            peanut.put(FieldAnimal.BIRTHDATE, "2021-08-01");
            peanut.put(FieldAnimal.COMMAND, "Roll,Spin");
            petCollection.add(factory.detAnimal(peanut));
//

        }
    }
