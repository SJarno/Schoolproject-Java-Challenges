package rockpaperscissors;

public abstract class Player {
    private int wins;
    private int losses;
    private String id;

    public Player(String id) {
        this.wins = 0;
        this.losses = 0;
        this.id = id;

    }
    public String getId() {
        return this.id;
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
