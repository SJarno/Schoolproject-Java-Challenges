package numberstostring;

import org.apache.commons.lang3.StringUtils;

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
        String parts[] = this.originalText.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string : parts) {
            sb.append(changeNumberToString(string)+" ");
        }
        this.parsedText = sb.toString().trim();
    }
    private String changeNumberToString(String input) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNumeric(input)) {
            int luku = Integer.valueOf(input);
            int kymmenet = (luku % 100 - luku % 10) / 10;

            String sadat = luku / 100 < 1 ? ""
                    : luku < 200 ? "sata" : luku / 100 > 1 ? oneToTen[luku / 100] + "sataa" : "";

            String kymmenetString = kymmenet > 1 ? oneToTen[kymmenet] + "kymmentä" 
                    : "";
            String ykkoset = luku < 10 ? oneToTen[luku % 10]
                    : kymmenet == 1 && luku % 10 == 0 ? oneToTen[10]
                    : kymmenet == 1 ? oneToTen[luku % 10] + "toista" 
                    : luku % 10 != 0 ? oneToTen[luku % 10]: "";

            sb.append(sadat);
            sb.append(kymmenetString);
            sb.append(ykkoset);
            return sb.toString();
        }
        return input;
    }

    
}
