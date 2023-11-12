package model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.animals.Pet;
import repository.Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class RegistryPets implements Registry {
    private final Database database;
    private ObjectMapper mapper = new ObjectMapper();

    public RegistryPets(Database database) {
        this.database = database;
    }
    public void addDataBase(HashMap<Enum<FieldAnimal>, String> data) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,Object>> list = mapper.readValue(new File("input.json"), new TypeReference<List<HashMap<String,Object>>>(){});
        for (HashMap<String,Object> map : list) {
            database.addNewAnimal(new PetsFactory().detAnimal(data));
        }

    }
    @Override
    public String addNewPet(HashMap<Enum<FieldAnimal>, String> data) throws IOException {
        if (data.get(FieldAnimal.NAME) == null || data.get(FieldAnimal.NAME).isEmpty()) {
            return "Не введена кличка питомца.";
        }
        if (ParsDate.checkDate(data.get(FieldAnimal.BIRTHDATE))) {
            database.addNewAnimal(new PetsFactory().detAnimal(data));
            String jsonInString = mapper.writeValueAsString(data);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("task_13-15/accounting_system_for_the_nursery2/database.json", true))) {
                bw.write(jsonInString + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(data);
            return "Новый питомец добавлен в базу.";
        } else {
            return "Не верно введена дата рождения.";
        }
    }

    @Override
    public String getCommandsPet(String namePet) {
        String result = "";
        if (namePet == null || namePet.isEmpty()) {
            return  "Не введена кличка питомца.";
        } else {
            for (Pet p : database.getAll()) {
                if (p.getName().equals(namePet)) {
                    result = "Список команд " + namePet +
                            " " + database.getCommandsPet(namePet).toString();
                }
            }
            if (result.isEmpty()){
                return "Питомец с такой кличкой отсутствует.";
            }else {
                return result;
            }
        }
    }

    @Override
    public String addNewCommand(HashMap<Enum<FieldAnimal>, String> newCommands) {
        String result = "";
        String name = newCommands.get(FieldAnimal.NAME);
        String commands = newCommands.get(FieldAnimal.COMMAND);
        if (name == null || name.isEmpty()) {
            return "Не введена кличка питомца.";
        } else if (commands == null || commands.isEmpty()) {
            return "Не введена новая команда.";
        } else {
            for (Pet p : database.getAll()) {
                if (p.getName().equals(name)) {
                    database.addNewCommand(newCommands);
                    result = getCommandsPet(name);
                }
            }
        }
        if (result.isEmpty()){
            return "Питомец с такой кличкой отсутствует.";
        }else {
            return result;
        }
    }

    @Override
    public String getPetsByBirthday(String birthday) {
        Collection<Pet> temp = null;
        StringBuilder result= new StringBuilder();
        if (ParsDate.checkDate(birthday)) {
            for (Pet p : database.getAll()) {
                if (p.getBirthDate().equals(birthday)) {
                    temp = database.getPetsByBirthday(birthday);
                }
            }
        } else {
            return  "Не верно введена дата рождения.";
        }
        if (temp ==null){
            return "Питомец с такой датой рождения отсутствует.";
        }else {
            for (Pet p : temp) {
                result.append(p).append("\n");
            }
        }
        return result.toString();
    }

    @Override
    public String getAll() {
        StringBuilder result = new StringBuilder();
        for (Pet p : database.getAll()) {
            result.append(p)
                    .append("\n");
        }
        if (result.isEmpty()) {
            return "База пуста.";
        } else {
            return result.toString();
        }
    }
    public String getAllName(){
        StringBuilder result = new StringBuilder();
        for (Pet p : database.getAll()) {
            result.append(p.getName())
                    .append(" ");
        }
        return result.toString();
    }
}
