package rockpaperscissors.domain;

import java.util.Random;

public class ComputerPlayer extends AbstractPlayer {

    public ComputerPlayer(String name) {
        super(name);

    }

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

}
