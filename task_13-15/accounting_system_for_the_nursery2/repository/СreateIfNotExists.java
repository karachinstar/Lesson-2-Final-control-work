package repository;


import java.io.File;
import java.io.IOException;

public class СreateIfNotExists {
    static boolean createIfNotExists(String fileName) throws IOException {
        return (new File(fileName)).exists()
                ? false
                : (new File(fileName)).createNewFile();
    }
}