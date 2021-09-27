package pinandpukcodes.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsercodeGenerator implements CodeGenerator {
    private int minValueForCode;
    private int maxValueForCode;
    /* private int code; */

    public UsercodeGenerator(int min, int max) {
        this.minValueForCode = min;
        this.maxValueForCode = max;
    }
    public void setMinValueForCode(int value) {
        if (value > 3) {
            this.minValueForCode = value;
        }
    }
    public void setMaxValueForCode(int value) {
        if (value > 3) {
            this.maxValueForCode = value;
        }
    }

    @Override
    public List<Integer> generateCode(int codeLength) {
        codeLenghtCheck(codeLength);
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < codeLength; i++) {
            while (true) {
                int randomNumber = random.nextInt(9) + 1;
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber);
                    break;
                }
            }
        }
        return numbers;
    }

    public boolean codeLengthIShortOrLong(int length) {
        return length < minValueForCode || length > maxValueForCode;
    }
    public void codeLenghtCheck(int codeLength) {
        if (codeLengthIShortOrLong(codeLength)) {
            throw new IllegalArgumentException("Pituus ei saa olla alle näljä tai yli kahdeksan");
        }
    }

}
