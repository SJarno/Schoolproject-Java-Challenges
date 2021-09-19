package caloriesvsjoules.ui;

import java.util.Scanner;

import caloriesvsjoules.domain.ConverterInterface;

public class UserInterface {
    private Scanner scanner;
    private ConverterInterface converter;

    public UserInterface(Scanner scanner, ConverterInterface converter) {
        this.converter = converter;
        this.scanner = scanner;
    }

    private void instructions() {
        System.out.println("Valikko:");
        System.out.println("1.Kalorit jouleiksi");
        System.out.println("2.Joulet kaloreiksi");
        System.out.print("Valitse muunnos:");
    }

    private void handleChoices(String input) {
        if (input.equals("1")) {
            System.out.println("Kalorit: ");
            double tulos = converter.convertCaloriesToJoules(Double.valueOf(scanner.nextLine().trim()));
            System.out.println("Tulos: " + tulos + " joulea");
        } else if (input.equals("2")) {
            System.out.println("Joulet:");
            System.out.println("Tulos: " + converter.convertJoulesToCalories(Double.valueOf(scanner.nextLine().trim()))
                    + " kaloria");
        }
    }

    public void init() {
        while (true) {
            instructions();
            String input = scanner.nextLine().trim();
            if (input.equals("X")) {
                System.out.println("Poistutaan ohjelmasta");
                break;
            }
            handleChoices(input);

        }
    }

}
