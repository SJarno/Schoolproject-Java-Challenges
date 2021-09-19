package rockpaperscissors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import rockpaperscissors.domain.ComputerPlayer;

public class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;

    @BeforeEach
    public void init() {
        this.computerPlayer = new ComputerPlayer("Computer player");
    }

    @Test
    public void testDefaultValues() {
        assertEquals("Computer player", computerPlayer.getName());
        assertEquals(0, computerPlayer.getLosses());
        assertEquals(0, computerPlayer.getWinnings());
    }

    @Test
    public void testAddingOneLong() {
        for (int i = 0; i < 101; i++) {
            assertEquals(i, computerPlayer.getLosses());
            assertEquals(i, computerPlayer.getWinnings());
            computerPlayer.addLoss();
            computerPlayer.addWin();
        }
    }


    @RepeatedTest(100)
    public void testRandomNumberLong() {
        int randomNumber = this.computerPlayer.getRandomNumber();
        assertTrue(randomNumber >= 1 && randomNumber <= 3);
        System.out.println(randomNumber);

    }

}
