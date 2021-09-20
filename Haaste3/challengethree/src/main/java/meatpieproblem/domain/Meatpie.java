package meatpieproblem.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Meatpie implements Grocery {
    private int price;
    private String type;
    private String name;

    public Meatpie(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = convertToCents(price);
    }

    private int convertToCents(double value) {
        return (int) new BigDecimal(value * 100).setScale(10, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double getPrice() {
        return (double) this.price / 100;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCents() {
        return price;
    }

    public void giveDiscount(double percent) {
        if (percent > 1 || percent < 0) {
            throw new IllegalArgumentException("Alennus ei voi olla yli 100% tai alle 0%");
        }
        price -= (price * percent);
    }

}
