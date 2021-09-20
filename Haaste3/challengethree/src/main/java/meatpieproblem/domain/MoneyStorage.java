package meatpieproblem.domain;

public interface MoneyStorage {
    void add(double value);
    void take(double value);
    boolean canTake(double value);
    int convertValue(double value);
    boolean checkValue(double value);
    double getValue();
}
