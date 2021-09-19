package rockpaperscissors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import rockpaperscissors.domain.AbstractPlayer;

public class AbstractPlayerTest {

    private AbstractPlayer player;

    @BeforeEach
    public void init() {
        this.player = new AbstractPlayer("abstraction"){

            @Override
            public int getRandomNumber() {
                return 0;
            }
            
        };
    }

    @ParameterizedTest
    @ValueSource(strings = { "mikko", "johannes", "kuukkeli" })
    public void testName(String name) {
        assertEquals("abstraction", player.getName());
        assertNotEquals(name, player.getName());
    }

    @Test
    public void testWinnsIsZero() {
        assertEquals(0, player.getWinnings());
    }

    @Test
    public void addWinnAddsOneShort() {
        this.player.addWin();
        assertEquals(1, this.player.getWinnings());

    }

    @Test
    public void testAddWinnsAddsOneMedium() {
        for (int i = 0; i < 101; i++) {
            assertEquals(i, this.player.getWinnings());
            this.player.addWin();

        }
    }

    @Test
    public void testLossesIsZero() {
        assertEquals(0, this.player.getLosses());
    }

    @Test
    public void testAddLossAddsOneShort() {
        this.player.addLoss();
        assertEquals(1, this.player.getLosses());
    }

    @Test
    public void testAddLossAddsOneLong() {
        for (int i = 0; i < 100; i++) {
            assertEquals(i, this.player.getLosses());
            this.player.addLoss();
        }
    }

}
