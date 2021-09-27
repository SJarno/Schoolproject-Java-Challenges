package counternumbers;

import java.util.ArrayList;

import java.util.List;

import counternumbers.domain.NumberSwitcher;

public class App {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(5);
        numbers.add(-15);
        numbers.add(34);
        numbers.add(-3);

        NumberSwitcher numberSwitcher = new NumberSwitcher();
        numberSwitcher.setOriginal(numbers);
        System.out.println(numberSwitcher.getOriginal());
        numberSwitcher.turnNumbers();
        System.out.println("Muutettu: "+numberSwitcher.getChanged());
        numberSwitcher.addToOriginal(66);
        
        System.out.println(numbers);
        System.out.println(numberSwitcher.getOriginal());
        

    }

}
