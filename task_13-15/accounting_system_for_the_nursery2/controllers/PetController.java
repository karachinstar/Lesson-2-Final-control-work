package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.FieldAnimal;
import model.ParsDate;
import model.Registry;
import views.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PetController implements Controller {
    private final Registry registry;
    private View view;
    public PetController(Registry registry) {
        this.registry = registry;
    }

    @Override
    public void addNewPet() throws IOException {
        HashMap<Enum<FieldAnimal>, String> data = new HashMap<>();
        view.print("Введите тип питомца(dog, cat, hamster): ");
        String type = view.getString();
        if ((type.equals("dog")) || (type.equals("cat")) || (type.equals("hamster"))) {
            data.put(FieldAnimal.TYPE, type);
        } else {
            view.println("Введен не верный тип питомца.");
            return;
        }
        view.print("Введите имя питомца: ");
        data.put(FieldAnimal.NAME, view.getString());
        view.print("Введите дату(в формате yyyy-mm-dd): ");
        String date = view.getString();
        if (ParsDate.checkDate(date)) {
            data.put(FieldAnimal.BIRTHDATE, date);
        } else {
            view.println("Введена не верная дата.");
            return;
        }
        view.print("Введите новую команду(или команды через запятую: ");
        data.put(FieldAnimal.COMMAND, view.getString());
        view.println(registry.addNewPet(data));
    }

    @Override
    public void getCommandsPet() {
        view.println("Питомцы: " + registry.getAllName());
        view.print("Введите имя питомца: ");
        view.println(registry.getCommandsPet(view.getString()));
    }

    @Override
    public void addNewCommand() {
        HashMap<Enum<FieldAnimal>, String> data = new HashMap<>();
        view.println("Питомцы: " + registry.getAllName());
        view.print("Введите имя питомца: ");
        data.put(FieldAnimal.NAME, view.getString());
        view.print("Введите новую команду(или команды через запятую: : ");
        data.put(FieldAnimal.COMMAND, view.getString());
        view.println(registry.addNewCommand(data));
    }

    @Override
    public void getPetsByBirthday() {
        view.print("Введите дату(в формате yyyy-mm-dd): ");
        view.println(registry.getPetsByBirthday(view.getString()));
    }

    @Override
    public void getAll() {
        view.println(registry.getAll());
    }

    @Override
    public void exit() {
        view.println("Завершение работы приложения.");
        view.scannerClose();
        System.exit(1);
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }
}
