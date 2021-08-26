package rockpaperscissors;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String id) {
        super(id);

    }
    
    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }
    
}
