package grades.ui;

import java.util.Scanner;

import grades.domain.Grades;

public class UserInterface {
    private Grades grades;
    private boolean finnish;
    private Scanner scanner;

    public UserInterface(Scanner scanner, boolean finnish) {
        this.grades = new Grades();
        this.scanner = scanner;
        this.finnish = finnish;
    }

    private String instructions() {
        return finnish ? "1) Asetukset, 2) Arvosana X) Poistu ohjelmasta" : "1) Settings 2) Grade X) Stop program";
    }

    private String giveInput() {
        return finnish ? "Anna arvosana " : "Give grade ";
    }

    private String outPut(int grade) {
        return finnish ? "Arvosana: " + grades.getGrade(grade, true) : "Grade: " + grades.getGrade(grade, false);
    }

    public void init() {
        while (true) {
            System.out.println(instructions());
            System.out.print("> ");
            String userInput = scanner.nextLine().trim();
            if (userInput.equals("X")) {
                System.out.println(finnish ? "Poistutaan ohjelmasta" : "Closing program");
                break;
            }
            if (userInput.equals("1")) {
                settingsLang();
            }
            if (userInput.equals("2")) {
                gradingOutput();

            }

        }
    }

    private void gradingOutput() {
        while (true) {
            System.out.print(giveInput());
            String userInput = scanner.nextLine().trim();
            if (userInput.equals("X")) {
                break;
            }
            System.out.println(outPut(Integer.valueOf(userInput)));
        }
    }

    private void settingsLang() {
        System.out.println(
                "1) Vaihda kieli Suomeksi/Change lang to Fin 2) Vaihda kieli englanniksi/Change language to English X) Mene takaisin/Go back");
        while (true) {
            System.out.print("> ");
            String userInput = scanner.nextLine().trim();
            if (userInput.equals("1")) {
                finnish = true;
                System.out.println("Kieli asetettu suomeksi / Language set to finnish");
            }
            if (userInput.equals("2")) {
                finnish = false;
                System.out.println("Kieli asetettu englanniksi / Language set to English");
            }
            if (userInput.equals("X")) {
                break;
            }
        }
    }

}
