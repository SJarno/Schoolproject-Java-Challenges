package caloriesvsjoules.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter implements ConverterInterface {

    @Override
    public double convertCaloriesToJoules(double calories) {
        return new BigDecimal(calories * 4.184).setScale(3, RoundingMode.HALF_UP).doubleValue();

    }

    @Override
    public double convertJoulesToCalories(double joules) {
        return new BigDecimal(joules * 0.2390057361).setScale(10, RoundingMode.HALF_UP).doubleValue();
        

    }

}
