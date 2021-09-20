package grades.domain;

import java.util.HashMap;
import java.util.Map;

public class Grades {
    private Map<Integer, Grade> grades;

    public Grades() {
        this.grades = new HashMap<>();
        grades.put(0, Grade.ZERO);
        grades.put(1, Grade.ONE);
        grades.put(2, Grade.TWO);
        grades.put(3, Grade.THREE);
        grades.put(4, Grade.FOUR);
        grades.put(5, Grade.FIVE);
    }
    public String getGrade(int grade, boolean inFinnish) {
        if (grades.containsKey(grade)) {
            return inFinnish ? grades.get(grade).getFinnishGrade(): grades.get(grade).getUSGrade();
        }
        return inFinnish ? "Arvosanaa ei löytynyt": "Grade not found";
        
    }
    
}
