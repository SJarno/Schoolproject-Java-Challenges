package grades.domain;

public enum Grade {
    ZERO("Hylätty", "Fail"), 
    ONE("Välttävä", "Pass"), 
    TWO("Tyydyttävä", "Satisfactory"), 
    THREE("Hyvä", "Good"), 
    FOUR("Kiitettävä", "Superior"), 
    FIVE("Erinomainen", "Outstanding");

    private String inFinnish;
    private String inEnglishUsa;

    private Grade(String inFinnish, String inEnglishUsa) {
        this.inFinnish = inFinnish;
        this.inEnglishUsa = inEnglishUsa;
    }
    public String getFinnishGrade() {
        return this.inFinnish;
    } 
    public String getUSGrade() {
        return this.inEnglishUsa;
    }

}
