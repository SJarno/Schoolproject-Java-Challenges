package counternumbers.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberSwitcherTest {
    private NumberSwitcher nSwitcher;
    private List<Integer> numbers;
    private List<Integer> turnedNumbers;

    @BeforeEach
    void setUp() {
        this.nSwitcher = new NumberSwitcher();
        this.numbers = new ArrayList<>(Arrays.asList(1, 5, -15, 34, -3));
        nSwitcher.setOriginal(numbers);

        this.turnedNumbers = new ArrayList<>(Arrays.asList(-1, -5, 15, -34, 3));
    }

    @Test
    void testLastNumber() {
        int lastNumber = numbers.get(numbers.size() - 1);
        assertEquals(-3, lastNumber);
        int lastNumberOriginal = nSwitcher.getOriginal().get(nSwitcher.getOriginal().size() - 1);
        assertEquals(lastNumber, lastNumberOriginal);
    }

    @Test
    void testAddToOriginal() {
        nSwitcher.addToOriginal(57);
        assertEquals(numbers.size(), nSwitcher.getOriginal().size());
        assertEquals(57, nSwitcher.getOriginal().get(nSwitcher.getOriginal().size()-1));
    }


    @Test
    void testGetOriginal() {
        assertEquals(numbers.size()+1, nSwitcher.getOriginal().size());
        assertEquals(numbers, nSwitcher.getOriginal());
        
    }

    @Test
    void testSetOriginal() {
        List<Integer> newList = new ArrayList<>(Arrays.asList(4, 26, -21));
        nSwitcher.setOriginal(newList);
        assertEquals(newList.size(), nSwitcher.getOriginal().size());
        assertNotEquals(numbers.size(), nSwitcher.getOriginal().size());
        
        assertEquals(newList, nSwitcher.getOriginal());
    }

    @Test
    void testTurnNumber() {
        int number = 43;
        assertEquals(-number, -43);
        number = -43;
        assertEquals(-number, 43);
    }

    @Test
    void testTurnNumbers() {
        nSwitcher.turnNumbers();
        assertEquals(this.turnedNumbers, nSwitcher.getChanged());
        assertNotEquals(this.numbers, nSwitcher.getChanged());
    }
}
