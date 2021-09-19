package rockpaperscissors.domain;

public interface Player {
    int wins = 0;
    int losses = 0;
    String name = "";
    void addWin();
    void addLoss();
    int getRandomNumber();
    int getWinnings();
    int getLosses();
    String getName();
}
