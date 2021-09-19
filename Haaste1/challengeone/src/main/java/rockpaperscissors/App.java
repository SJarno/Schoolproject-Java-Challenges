package rockpaperscissors;

import java.util.Scanner;

import rockpaperscissors.logic.GameLogic;
import rockpaperscissors.ui.UserInterface;

public class App {

    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(scanner, gameLogic);
        userInterface.init();
        
        
        
    }

}
