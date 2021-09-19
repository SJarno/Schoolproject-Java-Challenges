package caloriesvsjoules.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConverterTest {
    private Converter converter;

    @BeforeEach
    public void init() {
        this.converter = new Converter();
    }

    @Test
    void testConvertCaloriesToJoulesDecimalsByTen() {
        // assert base number
        assertEquals(4.184, converter.convertCaloriesToJoules(1));
        //assert by *10
        assertEquals(41.84, converter.convertCaloriesToJoules(10));
        assertEquals(418.4, converter.convertCaloriesToJoules(100));
        assertEquals(4184, converter.convertCaloriesToJoules(1000));
        assertEquals(41840, converter.convertCaloriesToJoules(10000));
        assertEquals(418400, converter.convertCaloriesToJoules(100000));
    }

    @Test
    void testCaloriesToJoulesRandompickedNumbers() {
        assertEquals(29.288, converter.convertCaloriesToJoules(7));
        assertEquals(54.392, converter.convertCaloriesToJoules(13));
        assertEquals(782.408, converter.convertCaloriesToJoules(187));
        assertEquals(9702.696, converter.convertCaloriesToJoules(2319));
        assertEquals(365016.344, converter.convertCaloriesToJoules(87241));
        assertEquals(609654.824, converter.convertCaloriesToJoules(145711));
    }

    @Test
    void testConvertJoulesToCalories() {
        // assert that base number is correct!
        assertEquals(0.2390057361, converter.convertJoulesToCalories(1));
        // assert by *10
        assertEquals(2.390057361, converter.convertJoulesToCalories(10));
        assertEquals(23.90057361, converter.convertJoulesToCalories(100));
        assertEquals(239.0057361, converter.convertJoulesToCalories(1000));
        assertEquals(2390.057361, converter.convertJoulesToCalories(10_000));
        assertEquals(23900.57361, converter.convertJoulesToCalories(100_000));
        assertEquals(239005.7361, converter.convertJoulesToCalories(1_000_000));
        assertEquals(2390057.361, converter.convertJoulesToCalories(10_000_000));
        assertEquals(23900573.61, converter.convertJoulesToCalories(100_000_000));
        assertEquals(239005736.1, converter.convertJoulesToCalories(1_000_000_000));
        
    }
    @Test
    void testJoulesToCaloriesRandomNumbers() {
        assertEquals(1.6730401527, converter.convertJoulesToCalories(7));
        // assert by *10
        assertEquals(4.5411089859, converter.convertJoulesToCalories(19));
        assertEquals(92.4952198707, converter.convertJoulesToCalories(387));
        assertEquals(2_359.9426382514, converter.convertJoulesToCalories(9_874));
        assertEquals(3_397.2275329254, converter.convertJoulesToCalories(14_214));
        assertEquals(112_706.2619325243, converter.convertJoulesToCalories(47_1563));
        assertEquals(608_960.5639575651, converter.convertJoulesToCalories(2_547_891));
        

    }
}
