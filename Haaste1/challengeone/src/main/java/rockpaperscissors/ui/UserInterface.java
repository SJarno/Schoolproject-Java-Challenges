package rockpaperscissors.ui;

import java.util.Scanner;

import rockpaperscissors.domain.ComputerPlayer;
import rockpaperscissors.domain.HumanPlayer;
import rockpaperscissors.logic.GameLogic;

public class UserInterface {
    private GameLogic gameLogic;
    private Scanner scanner;

    public UserInterface(Scanner scanner, GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        this.scanner = scanner;

    }

    private void createPlayer() {
        System.out.print("Anna pelaajan nimi: ");
        String playerName = scanner.nextLine();
        System.out.print("Anna vastapelaajan nimi: ");
        String compName = scanner.nextLine();
        gameLogic.setPlayers(new HumanPlayer(playerName), new ComputerPlayer(compName));
    }

    private void printLogo() {
        /*
         * Ascii art from:
         * https://gist.github.com/wynand1004/b5c521ea8392e9c6bfe101b025c39abe
         */
        System.out.println("    _______");
        System.out.println("---'   ____)");
        System.out.println("      (_____)");
        System.out.println("      (_____)");
        System.out.println("      (____)");
        System.out.println("---.__(___)");
        System.out.println();
        System.out.println("    ________");
        System.out.println("---'    ____)____");
        System.out.println("           ______)");
        System.out.println("          _______)");
        System.out.println("         _______)");
        System.out.println("---.__________)");
        System.out.println();
        System.out.println("    _______");
        System.out.println("---'   ____)____");
        System.out.println("          ______)");
        System.out.println("       __________)");
        System.out.println("      (____)");
        System.out.println("---.__(___)");
        System.out.println();
    }

    private void instructions() {
        System.out.println();
        System.out.println("Valinnat: ");
        System.out.println("1)Kivi, 2)paperi, 3)sakset");
        System.out.println("Pelaaja valitsee...");
    }

    private int convertInput(String input) {
        try {
            return Integer.valueOf(input);
        } catch (Exception e) {
            System.out.println("Valite numero väliltä 1-3");
        }
        return 0;
    }

    private boolean checkRange(int input) throws IllegalArgumentException {
        return input > 0 && input < 4 ? true : false;
    }

    private void defineWinner(int playerChoice, int computerChoice) {
        try {
            if (gameLogic.playerWon(playerChoice, computerChoice)) {
                System.out.println("Pelaaja voitti! :D");
            } else {
                System.out.println(gameLogic.getComputerPlayer().getName() + " voitti! :((");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkInput(String playerChoice) {
        int userChoice = convertInput(playerChoice);
        if (checkRange(userChoice)) {
            System.out.println("Valitsit " + gameLogic.getChoice(userChoice));
            int computerChoice = gameLogic.getComputerPlayer().getRandomNumber();
            System.out.println(gameLogic.getComputerPlayer().getName() + " valitsee...");
            System.out.println(
                    gameLogic.getComputerPlayer().getName() + " valitsi " + gameLogic.getChoice(computerChoice));
            System.out.println();
            defineWinner(userChoice, computerChoice);
            System.out.println();
            System.out.println(gameLogic.statistics());
        }
    }

    public void init() {
        printLogo();
        createPlayer();
        instructions();
        while (true) {
            System.out.print("Valitse: ");
            String playerChoice = scanner.nextLine().trim().toUpperCase();
            if (playerChoice.equals("X")) {
                System.out.println("Lopetetaan peli");
                break;
            }
            System.out.println();
            checkInput(playerChoice);

        }

    }
}
