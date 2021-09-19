package rockpaperscissors.logic;

import java.util.HashMap;
import java.util.Map;

import rockpaperscissors.domain.ComputerPlayer;
import rockpaperscissors.domain.HumanPlayer;
import rockpaperscissors.domain.Player;

public class GameLogic {
    private Player humanPlayer;
    private Player computerPlayer;
    private Map<Integer, RPS> choices;

    /* Constructor takes Player type interface */
    public GameLogic() {
        this.choices = new HashMap<>();
        choices.put(1, RPS.ROCK);
        choices.put(2, RPS.PAPER);
        choices.put(3, RPS.SCISSORS);
    }
    public void setPlayers(Player humanPlayer, Player compPlayer) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = compPlayer;
    }

    public boolean playerWon(int humanChoide, int computerChoice) {
        if (humanChoide < 1 || humanChoide > 3) {
            throw new IllegalArgumentException("Valitse numero 1-3 välillä");

        }
        if (humanChoide == computerChoice) {
            throw new IllegalArgumentException("Tasapeli!");
        }
        int ordinal = choices.get(humanChoide).compareTo(choices.get(computerChoice));
        if (ordinal == -2 || ordinal == 1) {
            humanPlayer.addWin();
            computerPlayer.addLoss();
            return true;
        }
        humanPlayer.addLoss();
        computerPlayer.addWin();
        return false;
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public Player getComputerPlayer() {
        return computerPlayer;
    }

    public Enum<RPS> getChoice(int choise) {
        return this.choices.get(choise);
    }

    public String statistics() {
        return humanPlayer.getName()+": " + humanPlayer.getWinnings() + " - "+computerPlayer.getName()+": " + computerPlayer.getWinnings();
    }
}
