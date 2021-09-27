package grades;

import java.util.Scanner;

import grades.ui.UserInterface;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner, true);
        userInterface.init();
    }

}
