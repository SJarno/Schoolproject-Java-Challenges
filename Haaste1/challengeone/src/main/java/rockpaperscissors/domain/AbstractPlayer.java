package rockpaperscissors.domain;

public abstract class AbstractPlayer implements Player {
    private int wins;
    private int losses;
    private String name;

    public AbstractPlayer(String name) {
        this.wins = 0;
        this.losses = 0;
        this.name = name;

    }

    public String getName() {
        return this.name;
    }

    public int getWinnings() {
        return this.wins;
    }

    public void addWin() {
        this.wins += 1;
    }

    public int getLosses() {
        return this.losses;
    }

    public void addLoss() {
        this.losses += 1;
    }

}
