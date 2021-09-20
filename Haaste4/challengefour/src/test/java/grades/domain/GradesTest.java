package grades.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GradesTest {
    private Grades grades;
    private List<String> finnishGrades;
    private List<String> UsGrades;

    @BeforeEach
    public void setUp() {
        grades = new Grades();
        finnishGrades = new ArrayList<>(
                Arrays.asList("Hylätty", "Välttävä", "Tyydyttävä", "Hyvä", "Kiitettävä", "Erinomainen"));
        UsGrades = new ArrayList<>(
            Arrays.asList("Fail", "Pass", "Satisfactory", "Good", "Superior", "Outstanding"));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4, 5 })
    void testGetGradesInFinnish(int number) {
        assertEquals(finnishGrades.get(number), grades.getGrade(number, true));

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void testGetGradesInEnglish(int number) {
        assertEquals(UsGrades.get(number), grades.getGrade(number, false));
    }
    @ParameterizedTest
    @ValueSource(ints = {-1, 6, 7})
    void testGradeNotFound(int number) {
        assertEquals("Arvosanaa ei löytynyt", grades.getGrade(number, true));
        assertEquals("Grade not found", grades.getGrade(number, false));

    }
}
