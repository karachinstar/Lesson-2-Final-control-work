package views;

import controllers.Controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PetView implements View {
    private final Controller controller;

    public PetView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            println("*** Реестр домашних питомцев ***");
            println("================================");
            println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ.");
            println("1. Добавить нового питомца.");
            println("2. Получить список команд питомца.");
            println("3. Обучить питомца новым командам.");
            println("4. Получить список питомцев по дате рождения.");
            println("5. Получить базу питомцев.");
            print("Пожалуйста, выберите пункт меню: ");
            try {
                int number = scanner.nextInt();
                switch (number) {
                    case 0 -> {
                        scanner.close();
                        controller.exit();
                    }
                    case 1 -> controller.addNewPet();
                    case 2 -> controller.getCommandsPet();
                    case 3 -> controller.addNewCommand();
                    case 4 -> controller.getPetsByBirthday();
                    case 5 -> controller.getAll();
                    default -> println("Укажите корректный пункт меню.");
                }
            } catch (InputMismatchException e) {
                println("Введено не корректное значение.");
                run();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void println(String string) {
        System.out.println(string);
    }

    @Override
    public void print(String string) {
        System.out.print(string);
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public void scannerClose() {
        scanner.close();
    }
}
