package pinandpukcodes.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UsercodeGeneratorTest {
    private UsercodeGenerator uGenerator;

    @BeforeEach
    void setUp() {
        this.uGenerator = new UsercodeGenerator(4, 8);
    }

    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8 })
    void testThatOnlyOneOccurancePerNumber(int length) {
        List<Integer> code = uGenerator.generateCode(length);
        for (Integer integer : code) {
            int occurance = Collections.frequency(code, integer);
            assertEquals(1, occurance);
        }

    }
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3, 9})
    void testWrongInputThrowsException(int length) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            uGenerator.generateCode(length);
        });
        assertEquals("Pituus ei saa olla alle näljä tai yli kahdeksan", exception.getMessage());
    }
    @Test
    void codeLengthChecks() {
        assertTrue(uGenerator.codeLengthIShortOrLong(3));
        assertFalse(uGenerator.codeLengthIShortOrLong(4));
        assertFalse(uGenerator.codeLengthIShortOrLong(8));
        assertTrue(uGenerator.codeLengthIShortOrLong(9));
    }
}
