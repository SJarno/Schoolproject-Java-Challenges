package numberstostring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringParseNumberTest {

    private Map<Integer, String> numbersAsStrings = new HashMap<>();
    private StringParser sParser;

    @BeforeEach
    public void createInitialMap() {
        numbersAsStrings.put(0, "nolla");
        numbersAsStrings.put(1, "yksi");
        numbersAsStrings.put(2, "kaksi");
        numbersAsStrings.put(3, "kolme");
        numbersAsStrings.put(4, "neljä");
        numbersAsStrings.put(5, "viisi");
        numbersAsStrings.put(6, "kuusi");
        numbersAsStrings.put(7, "seitsemän");
        numbersAsStrings.put(8, "kahdeksan");
        numbersAsStrings.put(9, "yhdeksän");
        numbersAsStrings.put(10, "kymmenen");

        sParser = new StringParser();

    }

    public void initConstants(int beginning, int end) {
        for (int i = beginning; i < end; i++) {
            int ykkoset = i % 10;
            int kymmenet = i / 10;
            int sadat = i / 100;
            String luku =
                    // Below 100
                    i < 11 ? numbersAsStrings.get(i) // if under 11
                            : i < 20 ? numbersAsStrings.get(ykkoset) + "toista" // if under 20
                                    : i < 100 && i % 10 == 0 ? numbersAsStrings.get(kymmenet) + "kymmentä" // tens
                                            : i < 100
                                                    ? numbersAsStrings.get(kymmenet) + "kymmentä"
                                                            + numbersAsStrings.get(ykkoset)
                                                    // one hundred and above
                                                    : i == 100 ? "sata"
                                                            : i < 111 ? "sata" + numbersAsStrings.get(i % 100)
                                                                    : i < 120
                                                                            ? "sata" + numbersAsStrings
                                                                                    .get(i % 100 - 10) + "toista"
                                                                            : i < 200 && (i - 100) % 10 == 0
                                                                                    ? "sata" + numbersAsStrings.get(
                                                                                            kymmenet - 10) + "kymmentä"
                                                                                    : i < 200 ? "sata"
                                                                                            + numbersAsStrings
                                                                                                    .get(kymmenet - 10)
                                                                                            + "kymmentä"
                                                                                            + numbersAsStrings
                                                                                                    .get((i % 100) % 10)
                                                                                            // two hunderd and above
                                                                                            : i % 100 == 0
                                                                                                    ? numbersAsStrings
                                                                                                            .get(sadat)
                                                                                                            + "sataa"
                                                                                                    : i % 100 < 11
                                                                                                            ? numbersAsStrings
                                                                                                                    .get(sadat)
                                                                                                                    + "sataa"
                                                                                                                    + numbersAsStrings
                                                                                                                            .get(i % 100)
                                                                                                            : i % 100 < 20
                                                                                                                    ? numbersAsStrings
                                                                                                                            .get(sadat)
                                                                                                                            + "sataa"
                                                                                                                            + numbersAsStrings
                                                                                                                                    .get(i % 100
                                                                                                                                            % 10)
                                                                                                                            + "toista"
                                                                                                                    : i % 100
                                                                                                                            % 10 == 0
                                                                                                                                    ? numbersAsStrings
                                                                                                                                            .get(sadat)
                                                                                                                                            + "sataa"
                                                                                                                                            + numbersAsStrings
                                                                                                                                                    .get(i % 100
                                                                                                                                                            / 10)
                                                                                                                                            + "kymmentä"
                                                                                                                                    : i < 1000
                                                                                                                                            ? numbersAsStrings
                                                                                                                                                    .get(sadat)
                                                                                                                                                    + "sataa"
                                                                                                                                                    + numbersAsStrings
                                                                                                                                                            .get(i % 100
                                                                                                                                                                    / 10)
                                                                                                                                                    + "kymmentä"
                                                                                                                                                    + numbersAsStrings
                                                                                                                                                            .get(i % 100
                                                                                                                                                                    % 10)
                                                                                                                                            : "";
            numbersAsStrings.put(i, luku);

        }

    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })
    public void zeroToTenTrue(int numberInt) {
        initConstants(0, 11);
        sParser.readInput(String.valueOf(numberInt));
        sParser.parseText();
        assertEquals(numbersAsStrings.get(numberInt), sParser.getParsedText());

    }

    @Test
    public void oneToNineteen() {
        initConstants(0, 20);
        for (int i = 0; i < numbersAsStrings.size(); i++) {
            sParser.readInput(String.valueOf(i));
            sParser.parseText();
            assertEquals(numbersAsStrings.get(i), sParser.getParsedText());
        }

    }

    @Test
    public void zeroToNinetynine() {
        initConstants(0, 100);
        for (int i = 0; i < numbersAsStrings.size(); i++) {
            sParser.readInput(String.valueOf(i));
            sParser.parseText();
            assertEquals(numbersAsStrings.get(i), sParser.getParsedText());
        }

    }

    @Test
    public void zeroToNineNineNine() {
        initConstants(0, 1000);
        for (int i = 0; i < numbersAsStrings.size(); i++) {
            sParser.readInput(String.valueOf(i));
            sParser.parseText();
            assertEquals(numbersAsStrings.get(i), sParser.getParsedText());
        }
    }

}
