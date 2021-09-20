package grades;

import grades.domain.Grades;

public class App {
    
    
    public static void main(String[] args) {
        Grades ammattikoulugrades = new Grades();
        System.out.println(ammattikoulugrades.getGrade(1, true));
    }
    
}
