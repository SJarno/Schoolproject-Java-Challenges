package numberstostring;


import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    // constants as static
    static String alleYksitoista[] = { "nolla", "yksi", "kaksi", "kolme", "neljä", "viisi", "kuusi", "seitsemän",
            "kahdeksan", "yhdeksän", "kymmenen" };

    static Map<Integer, String> luvut = Stream
            .of(new Object[][] { 
                { 0, "nolla" }, 
                { 1, "yksi" }, 
                { 2, "kaksi" }, 
                { 3, "kolme" }, 
                { 4, "neljä" },
                { 5, "viisi" }, 
                { 6, "kuusi" }, 
                { 7, "seitsemän" }, 
                { 8, "kahdeksan" }, 
                { 9, "yhdeksän" },
                { 10, "kymmenen" } })
            .collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));
    // Version with array            
    public static void laskeTaulukolla() {
        for (int i = 0; i < 100; i++) {
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
    // version with map
    public static void laskeHajautustaululla() {
        for (int i = 0; i < 100; i++) {
            int kymmenet = i / 10;
            int ykkoset = i % 10;
            System.out.println(i < 11 ? luvut.get(i)
                    : i < 20 ? luvut.get(ykkoset) + "toista"
                            : i % 10 == 0 ? luvut.get(kymmenet) + "kymmentä"
                                    : luvut.get(kymmenet) + "kymmentä" + luvut.get(ykkoset));
        }
    
    }

    public static void main(String[] args) {
        // laskeTaulukolla();
        laskeHajautustaululla();

        
    }

}
