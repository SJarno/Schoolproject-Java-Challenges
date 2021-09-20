package meatpieproblem.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Wallet implements MoneyStorage {
    private int cents;

    public Wallet(double value) {
        this.cents = convertValue(value);
    }

    @Override
    public void add(double value) {
        if (checkValue(value)) {
            this.cents += convertValue(value);
        }

    }

    public boolean checkValue(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Arvo ei saa olla negatiivinen");

        }
        return true;
    }

    @Override
    public void take(double value) {
        if (checkValue(value) && canTake(value)) {
            this.cents -= convertValue(value);
        }

    }

    @Override
    public boolean canTake(double value) {
        if (cents - convertValue(value) < 0) {
            throw new IllegalArgumentException("Paastoa");
        }
        return cents - convertValue(value) >= 0 ? true : false;
    }

    @Override
    public int convertValue(double value) {
        return (int) new BigDecimal(value * 100).setScale(10, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double getValue() {
        return (double) this.cents / 100;
    }

}
