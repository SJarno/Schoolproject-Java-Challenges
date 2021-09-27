package numberstostring;


public class StringParser {
    private String originalText;
    private String parsedText;
    String oneToTen[] = { "nolla", "yksi", "kaksi", "kolme", "neljä", "viisi", "kuusi", "seitsemän",
            "kahdeksan", "yhdeksän", "kymmenen" };

    
    public String getOriginalText() {
        return this.originalText;
    }
    public String getParsedText() {
        return this.parsedText;
    }
    public void readInput(String input) {
        this.originalText = input;
    }
    public void parseText() {
        originalText = originalText.replace(".", " .");
        String parts[] = this.originalText.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string : parts) {
            sb.append(changeNumberToString(string)+" ");
        }
        
        this.parsedText = sb.toString().trim();
        parsedText = parsedText.replace(" .", ".");
    }
    private String changeNumberToString(String input) {
        StringBuilder sb = new StringBuilder();
        if (input.matches("\\d+")) {
            int value = Integer.valueOf(input);
            int tens = (value % 100 - value % 10) / 10;

            String hundredsString = value / 100 < 1 ? ""
                    : value < 200 ? "sata" : value / 100 > 1 ? oneToTen[value / 100] + "sataa" : "";

            String tensString = tens > 1 ? oneToTen[tens] + "kymmentä" 
                    : "";
            String onesString = value < 10 ? oneToTen[value % 10]
                    : tens == 1 && value % 10 == 0 ? oneToTen[10]
                    : tens == 1 ? oneToTen[value % 10] + "toista" 
                    : value % 10 != 0 ? oneToTen[value % 10]: "";

            sb.append(hundredsString);
            sb.append(tensString);
            sb.append(onesString);
            return sb.toString();
        }
        return input;
    }

    
}
