package meatpieproblem.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MeatpieTest {
    private Meatpie meatpie;

    @BeforeEach
    public void setUp() {
        this.meatpie = new Meatpie("Lihis", "pastry", 1.8);
    }

    @Test
    void testDefault() {
        assertEquals("Lihis", meatpie.getName());
        assertEquals("pastry", meatpie.getType());
        assertEquals(1.8, meatpie.getPrice());
    }

    @Test
    void getCents() {
        assertEquals(180, meatpie.getCents());
    }

    @Test
    void giveDiscount() {
        meatpie.giveDiscount(0.3);
        assertEquals(1.26, meatpie.getPrice());
    }

    @ParameterizedTest
    @ValueSource(doubles = { 1.1, -0.1, 100, -100, 1012, -5778 })
    void discountPercentUnderHundredAndNotBelowZero(double number) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            meatpie.giveDiscount(number);

        });
        assertEquals("Alennus ei voi olla yli 100% tai alle 0%", exception.getMessage());
    }

    @Test
    void testConvertToCents() {

    }

}
