package meatpieproblem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import meatpieproblem.domain.Meatpie;
import meatpieproblem.domain.MoneyStorage;
import meatpieproblem.domain.Wallet;
import meatpieproblem.ui.UserInterface;

public class App {

    public static void main(String[] args) {

        Wallet wallet = new Wallet(10);
        Meatpie pie = new Meatpie("Lihapiirakka", "Leivos", 1.3);
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(wallet, scanner);
        userInterface.addGrocery(pie);
        userInterface.init();

    }

}
