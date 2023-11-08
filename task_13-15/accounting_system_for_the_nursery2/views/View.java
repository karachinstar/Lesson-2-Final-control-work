package views;

import java.util.Scanner;

public interface View extends Runnable {
    Scanner scanner = new Scanner(System.in);

    void println(String string);

    void print(String string);

    String getString();

    void scannerClose();
}
