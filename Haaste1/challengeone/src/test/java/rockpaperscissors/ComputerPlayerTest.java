package rockpaperscissors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;

    @BeforeEach
    public void init() {
        this.computerPlayer = new ComputerPlayer("Computer player");
    }

    @Test
    public void testDefaultValues() {
        assertEquals("Computer player", computerPlayer.getId());
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

    @Test
    public void testRandomNumberShort() {
        int randomNumber = this.computerPlayer.getRandomNumber();
        assertTrue(randomNumber >= 1 && randomNumber <= 3);
    }

    @Test
    public void testRandomNumberLong() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = this.computerPlayer.getRandomNumber();
            assertTrue(randomNumber >= 1 && randomNumber <= 3);
            System.out.println(randomNumber);
        }

    }

}
