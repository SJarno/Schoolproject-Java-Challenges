package numberstostring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringParseClassTest {

    private StringParser sParser;

    @BeforeEach
    public void init() {
        sParser = new StringParser();
    }


    @Test
    void testGetParsedText() {
        String input = "Mister Huu's address is tattisuonkatu 4 A 123";
        sParser.readInput(input);
        sParser.parseText();
        assertEquals("Mister Huu's address is tattisuonkatu neljä A satakaksikymmentäkolme", sParser.getParsedText());
        assertNotEquals(sParser.getOriginalText(), sParser.getParsedText());
    }

    @Test
    void withDifferentInputs() {
        String inputsOriginal[] = {"Jorma on 18 vuotias", "saukonpaadenranta 4 A 10", "1 ei oo 2"};
        String inputsExcpected[] = {"Jorma on kahdeksantoista vuotias", "saukonpaadenranta neljä A kymmenen", "yksi ei oo kaksi"};
        for (int i = 0; i < inputsOriginal.length; i++) {
            sParser.readInput(inputsOriginal[i]);
            sParser.parseText();
            assertEquals(inputsExcpected[i], sParser.getParsedText());
        }


    }

    @Test
    void testReadInput() {
        String input = "Mister Huu's address is tattisuonkatu 4 A 123";
        sParser.readInput(input);
        sParser.parseText();
        assertEquals(input, sParser.getOriginalText());
        assertNotEquals("Mister Huu's addres is tattisuonkatu neljä A satakaksikymmentäkolme", sParser.getOriginalText());

    }
}
