package pinandpukcodes;

import java.util.ArrayList;
import java.util.List;

import pinandpukcodes.domain.UsercodeGenerator;

public class App {
    
    public static void main(String[] args) {
        
        UsercodeGenerator uGenerator = new UsercodeGenerator();
        System.out.println(uGenerator.generateCode(7));
    }
    
}
