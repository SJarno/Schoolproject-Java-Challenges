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
    private void results() {

    }
    public void init() {
        while (true) {
            System.out.println("Valikko:");
            System.out.println("1.Kalorit jouleiksi");
            System.out.println("2.Joulet kaloreiksi");
            System.out.print("Valitse muunnos:");
            String valinta = scanner.nextLine();
            if (valinta.equals("X")) {
                System.out.println("Poistutaan ohjelmasta");
                break;
            }
            if (valinta.equals("1")) {
                System.out.println("Kalorit: ");
                double tulos = converter.convertCaloriesToJoules(Double.valueOf(scanner.nextLine()));
                System.out.println("Tulos: "+tulos+" joulea");
            } else if (valinta.equals("2")) {
                System.out.println("Joulet:");
                System.out.println("Tulos: "+converter.convertJoulesToCalories(Double.valueOf(scanner.nextLine()))+" kaloria");
            }
        }
    }
    
}
