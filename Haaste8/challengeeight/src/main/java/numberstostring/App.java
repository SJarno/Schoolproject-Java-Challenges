package numberstostring;

import java.util.HashMap;

public class App {
    static String alleYksitoista[] = { "nolla", "yksi", "kaksi", "kolme", "neljä", "viisi", "kuusi", "seitsemän",
            "kahdeksan", "yhdeksän", "kymmenen" };

    public static void laskeTaulukolla() {
        for (int i = 0; i < 41; i++) {
            if (i < 20) { // jos alle 20
                System.out.println(i < 11 ? alleYksitoista[i] : alleYksitoista[i % 10] + "toista");
            } else { // jos on 20 ja yli
                int ykkoset = i % 10;
                int kymmenet = i / 10;
                System.out.println(i % 10 == 0 ? alleYksitoista[kymmenet] + "kymmentä"
                        : alleYksitoista[kymmenet] + "kymmentä" + alleYksitoista[ykkoset]);

            }

        }

    }

    public static void laskeHajautustaululla() {

    }

    public static void main(String[] args) {
        // laskeTaulukolla();
        HashMap<Integer, String> luvut = new HashMap<>();
        luvut.put(0, "nolla");
        luvut.put(1, "yksi");
        luvut.put(2, "kaksi");
        luvut.put(3, "kolme");
        luvut.put(4, "neljä");
        luvut.put(5, "viisi");
        luvut.put(6, "kuusi");
        luvut.put(7, "seitsemän");
        luvut.put(8, "kahdeksan");
        luvut.put(9, "yhdeksän");
        luvut.put(10, "kymmenen");

        for (int i = 0; i < 31; i++) {
            int kymmenet = i / 10;
            int ykkoset = i % 10;
            System.out.println(i < 11 ? luvut.get(i): i < 20 ? luvut.get(ykkoset)+"toista": i % 10 == 0 ? luvut.get(kymmenet)+"kymmentä": luvut.get(kymmenet)+"kymmentä"+luvut.get(ykkoset));
        }
    }

}
