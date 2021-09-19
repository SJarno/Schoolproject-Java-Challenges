package rockpaperscissors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rockpaperscissors.domain.HumanPlayer;

public class HumanPlayerTest {

    private HumanPlayer humanPlayer;

    @BeforeEach
    public void init() {
        this.humanPlayer = new HumanPlayer("Humanplayer");
    }

    @Test
    public void defaultValues() {
        assertEquals("Humanplayer", humanPlayer.getName());
        assertEquals(0, humanPlayer.getLosses());
        assertEquals(0, humanPlayer.getWinnings());
    
    }
}
