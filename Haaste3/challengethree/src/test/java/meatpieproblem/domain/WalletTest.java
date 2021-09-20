package meatpieproblem.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WalletTest {
    private MoneyStorage wallet;

    @BeforeEach
    public void setUp() {
        this.wallet = new Wallet(100);
    }

    @Test
    void testAdd() {
        assertEquals(100, wallet.getValue());
        wallet.add(10.5);
        assertEquals(110.5, wallet.getValue());
        wallet.add(2.5);
        assertEquals(113, wallet.getValue());
        wallet.add(0.9);
        assertEquals(113.9, wallet.getValue());
        wallet.add(0.2);
        assertEquals(114.1, wallet.getValue());
        wallet.add(0.9);
        assertEquals(115, wallet.getValue());
    }

    @Test
    void testCanTake() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            assertEquals(100, wallet.getValue());
            wallet.canTake(100.1);
            assertEquals(100, wallet.getValue());
        });
        assertEquals("Paastoa", exception.getMessage());
        assertEquals(true, wallet.canTake(99.9));
        assertEquals(100, wallet.getValue());
    }

    @Test
    void testCheckValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            wallet.checkValue(-1);
        });
        assertEquals("Arvo ei saa olla negatiivinen", exception.getMessage());
        assertEquals(true, wallet.checkValue(1));

    }

    @Test
    void testConvertValue() {
        assertEquals(10000, wallet.convertValue(wallet.getValue()));
    }

    @Test
    void testGetValue() {
        // initial value
        assertEquals(100, wallet.getValue());
    }

    @Test
    void testTake() {
        wallet.take(0.9);
        assertEquals(99.1, wallet.getValue());
        try {
            wallet.take(100);
        } catch (Exception e) {
            assertEquals(99.1, wallet.getValue());
        }

        wallet.take(99.1);
        assertEquals(0, wallet.getValue());
        try {
            wallet.take(1);
        } catch (Exception e) {
            assertEquals(0, wallet.getValue());
        }

    }
}
