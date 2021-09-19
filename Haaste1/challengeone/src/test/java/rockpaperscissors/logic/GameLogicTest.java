package rockpaperscissors.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import rockpaperscissors.domain.ComputerPlayer;
import rockpaperscissors.domain.HumanPlayer;
import rockpaperscissors.domain.Player;

public class GameLogicTest {
    private Player humPlayer;
    private Player compPlayer;
    private GameLogic gameLogic;

    @BeforeEach
    public void init() {
        this.humPlayer = new HumanPlayer("keijo");
        this.compPlayer = new ComputerPlayer("kone");
        this.gameLogic = new GameLogic();
        this.gameLogic.setPlayers(humPlayer, compPlayer);

    }
    @Test
    void testStatistics() {
        assertEquals("keijo: 0 - kone: 0", gameLogic.statistics());
        gameLogic.playerWon(1, 3);
        assertEquals("keijo: 1 - kone: 0", gameLogic.statistics());
        gameLogic.playerWon(1, 2);
        assertEquals("keijo: 1 - kone: 1", gameLogic.statistics());
    }

    @Test
    void testGetChoice() {
        assertEquals(RPS.ROCK, this.gameLogic.getChoice(1));
        assertEquals(RPS.PAPER, this.gameLogic.getChoice(2));
        assertEquals(RPS.SCISSORS, this.gameLogic.getChoice(3));
    }

    @Test
    void testGetHumanPlayerConstructors() {
        assertEquals(this.humPlayer, this.gameLogic.getHumanPlayer());
        assertEquals("keijo", this.gameLogic.getHumanPlayer().getName());
        assertEquals(0, this.gameLogic.getHumanPlayer().getWinnings());
        assertEquals(0, this.gameLogic.getHumanPlayer().getLosses());
    }

    @Test
    void testGetComputerPlayerConstructors() {
        assertEquals(this.compPlayer, this.gameLogic.getComputerPlayer());
        assertEquals("kone", this.gameLogic.getComputerPlayer().getName());
        assertEquals(0, this.gameLogic.getComputerPlayer().getWinnings());
        assertEquals(0, this.gameLogic.getComputerPlayer().getLosses());
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 4 })
    void testPlayerWonAssertWrongInputs(int number) {
        /* Check that wrong range throws exception */
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            this.gameLogic.playerWon(number, 1);
        });
        /* Check that the right message is thrown */
        assertEquals("Valitse numero 1-3 välillä", ex.getMessage());
    }

    @Test
    void testPlayerWins() {
        // Rock wins scissors, player wins, com loses 
        assertTrue(this.gameLogic.playerWon(1, 3));
        // Rock loses to paper
        assertFalse(this.gameLogic.playerWon(1, 2));
        // paper wins rock
        assertTrue(this.gameLogic.playerWon(2, 1));
        // paper loses to scissors
        assertFalse(this.gameLogic.playerWon(2, 3));
        // scissors wins paper
        assertTrue(this.gameLogic.playerWon(3, 2));
        // scissors loses to rock
        assertFalse(this.gameLogic.playerWon(3, 1));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testTieInPlayerWins(int number) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            gameLogic.playerWon(number, number);
        });
        assertEquals("Tasapeli!", exception.getMessage());
        assertEquals(0, gameLogic.getHumanPlayer().getWinnings());
        assertEquals(0, gameLogic.getHumanPlayer().getLosses());
        assertEquals(0, gameLogic.getComputerPlayer().getWinnings());
        assertEquals(0, gameLogic.getComputerPlayer().getLosses());
    }
    @Test
    void testWinngingsAndLosses() {
        //player wins, comp loses - Rock vs Scissors
        this.gameLogic.playerWon(1, 3);
        assertEquals(1, gameLogic.getHumanPlayer().getWinnings());
        assertEquals(0, gameLogic.getHumanPlayer().getLosses());
        assertEquals(0, gameLogic.getComputerPlayer().getWinnings());
        assertEquals(1, gameLogic.getComputerPlayer().getLosses());
        //player loses, comp wins - Rock vs Paper
        this.gameLogic.playerWon(1, 2);
        assertEquals(1, gameLogic.getHumanPlayer().getWinnings());
        assertEquals(1, gameLogic.getHumanPlayer().getLosses());
        assertEquals(1, gameLogic.getComputerPlayer().getWinnings());
        assertEquals(1, gameLogic.getComputerPlayer().getLosses());
        // player wins, paper vs rock
        this.gameLogic.playerWon(2, 1);
        assertEquals(2, gameLogic.getHumanPlayer().getWinnings());
        assertEquals(1, gameLogic.getHumanPlayer().getLosses());
        assertEquals(1, gameLogic.getComputerPlayer().getWinnings());
        assertEquals(2, gameLogic.getComputerPlayer().getLosses());
        // player loses, paper vs scissors
        this.gameLogic.playerWon(2, 3);
        assertEquals(2, gameLogic.getHumanPlayer().getWinnings());
        assertEquals(2, gameLogic.getHumanPlayer().getLosses());
        assertEquals(2, gameLogic.getComputerPlayer().getWinnings());
        assertEquals(2, gameLogic.getComputerPlayer().getLosses());
        // scissorsvspaper
        this.gameLogic.playerWon(3, 2);
        assertEquals(3, gameLogic.getHumanPlayer().getWinnings());
        assertEquals(2, gameLogic.getHumanPlayer().getLosses());
        assertEquals(2, gameLogic.getComputerPlayer().getWinnings());
        assertEquals(3, gameLogic.getComputerPlayer().getLosses());
        // scissors vs to rock
        this.gameLogic.playerWon(3, 1);
        assertEquals(3, gameLogic.getHumanPlayer().getWinnings());
        assertEquals(3, gameLogic.getHumanPlayer().getLosses());
        assertEquals(3, gameLogic.getComputerPlayer().getWinnings());
        assertEquals(3, gameLogic.getComputerPlayer().getLosses());
    }


}
