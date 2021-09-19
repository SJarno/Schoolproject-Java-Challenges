package caloriesvsjoules;

import java.util.Scanner;

import caloriesvsjoules.domain.Converter;
import caloriesvsjoules.ui.UserInterface;

public class App {
    
    public static void main(String[] args) {
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner, converter);
        userInterface.init();
    }
    
}
