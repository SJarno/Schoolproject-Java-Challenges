package meatpieproblem.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import meatpieproblem.domain.Grocery;
import meatpieproblem.domain.MoneyStorage;

public class UserInterface {
    private List<Grocery> storage;
    private MoneyStorage wallet;
    private Scanner scanner;

    public UserInterface(MoneyStorage wallet, Scanner scanner) {
        this.storage = new ArrayList<>();
        this.wallet = wallet;
        this.scanner = scanner;
    }
    public void addGrocery(Grocery grocery) {
        storage.add(grocery);
    }
    public void init() {
        System.out.println("Tarkista voiko ostaa lihapiirakkaa?");
        System.out.println("X - poistu ohjelmasta, 1) osta lihapiirakka");
        while (true) {
            System.out.println("Lompakossa rahaa: "+wallet.getValue());
            System.out.print("Käsky: ");
            String input = scanner.nextLine();
            if (input.equals("X")) {
                System.out.println("Poistutaan ohjelmasta");
            }
            if (input.equals("1")) {
                try {
                    wallet.take(storage.get(0).getPrice());
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                
            }
            
            
        }
        
        
    }
    
}
