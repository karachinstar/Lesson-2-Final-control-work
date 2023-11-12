package controllers;

import views.View;

import java.io.IOException;

public interface Controller {
    void addNewPet() throws IOException;

    void getCommandsPet();

    void addNewCommand();

    void getPetsByBirthday();

    void getAll();

    void exit();

    void setView(View view);

}
