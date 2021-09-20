package meatpieproblem;

import java.math.BigDecimal;
import java.math.RoundingMode;

import meatpieproblem.domain.MoneyStorage;
import meatpieproblem.domain.Wallet;

public class App {
    
    public static void main(String[] args) {

        
        MoneyStorage wallet = new Wallet(10);
        System.out.println(wallet.getValue());
        wallet.add(2.7);
        System.out.println(wallet.getValue());
        wallet.take(10.1);
        System.out.println(wallet.getValue());
        

    }
    
}
