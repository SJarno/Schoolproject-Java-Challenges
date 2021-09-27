package pinandpukcodes;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pinandpukcodes.domain.UsercodeGenerator;

public class App {
    
    public static void main(String[] args) {
        
        UsercodeGenerator uGenerator = new UsercodeGenerator(4, 8);
        /* System.out.println(uGenerator.generateCode(7)); */
        List<Integer> numerot = uGenerator.generateCode(7);
        StringBuilder sb = new StringBuilder();
        numerot.forEach(sb::append);
        System.out.println(sb.toString());
    }
    
}
