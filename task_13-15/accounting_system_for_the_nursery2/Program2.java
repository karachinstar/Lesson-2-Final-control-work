import controllers.Controller;
import controllers.PetController;
import model.Registry;
import model.RegistryPets;
import repository.Database;
import repository.PetsDatabase;
import views.PetView;
import views.View;

import javax.swing.*;

public class Program2 {
    public static void main(String[] args) {

        Database database = new PetsDatabase();
        Registry registry = new RegistryPets(database);
        Controller controller = new PetController(registry);
        View view = new PetView(controller);
        controller.setView(view);
        SwingUtilities.invokeLater(view);
    }
}