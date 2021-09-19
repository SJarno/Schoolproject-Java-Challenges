package rockpaperscissors.domain;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int getRandomNumber() {
        return 0;
    }

}
