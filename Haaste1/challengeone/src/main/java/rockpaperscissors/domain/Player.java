package rockpaperscissors.domain;

public interface Player {
    
    void addWin();
    void addLoss();
    int getRandomNumber();
    int getWinnings();
    int getLosses();
    String getName();
}
