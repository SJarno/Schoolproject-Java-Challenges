package pinandpukcodes.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsercodeGenerator implements CodeGenerator{

    @Override
    public List<Integer> generateCode(int lengthOfCode) {
        if (lengthOfCode < 4 || lengthOfCode > 8) {
            throw new IllegalArgumentException("Pituus ei saa olla alle näljä tai yli kahdeksan");
        }
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < lengthOfCode; i++) {
            while (true) {
                int randomNumber = random.nextInt(9)+1;
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber);
                    break;
                }
            }
        }
        return numbers;
    }

    
}
