package controllers;

import views.View;

public interface Controller {
    void addNewPet();

    void getCommandsPet();

    void addNewCommand();

    void getPetsByBirthday();

    void getAll();

    void exit();

    void setView(View view);

}
