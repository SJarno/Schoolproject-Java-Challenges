package numberstostring;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class App {
    // constants as static
    static String oneToTen[] = { "nolla", "yksi", "kaksi", "kolme", "neljä", "viisi", "kuusi", "seitsemän",
            "kahdeksan", "yhdeksän", "kymmenen" };

    // Version with array
    public static void laskeTaulukolla() {

        for (int i = 100; i <= 110; i++) {
            int ykkoset = i % 10;
            int kymmenet = i / 10;
            int sadat = i / 100;
            if (i < 20) { // jos alle 20
                System.out.println(i < 11 ? oneToTen[i] : oneToTen[i % 10] + "toista");
            } else if (i >= 20 && i < 100) { // if 20 and above
                System.out.println(i % 10 == 0 && kymmenet < 10 ? oneToTen[kymmenet] + "kymmentä"
                        : oneToTen[kymmenet] + "kymmentä" + oneToTen[ykkoset]);

            } else if (i >= 100) { // if 100 and above
                System.out.println(
                        i == 100 ? "sata" : sadat == 1 && ykkoset < 11 ? "sata" + oneToTen[ykkoset] : "");

            }

        }

    }


    public static void main(String[] args) {

        for (int i = 100; i < 1000; i++) {
            System.out.println(changeNumberToString(String.valueOf(i)));
        }
        
        /*
         * String merkkijono = "Herra Huun osoite on tattisuonkatu 4 A 100"; String
         * palat[] = merkkijono.split(" "); StringBuilder sb = new StringBuilder();
         * 
         * for (String string : palat) { sb.append(changeNumbeString(string)+" ");
         * 
         * } System.out.println(sb.toString().trim());
         */

    }

    public static String changeNumberToString(String merkkijono) {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNumeric(merkkijono)) {
            int luku = Integer.valueOf(merkkijono);
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
        return merkkijono;
    }

}
