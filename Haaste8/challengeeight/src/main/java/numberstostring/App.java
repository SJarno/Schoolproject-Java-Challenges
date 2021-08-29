package numberstostring;



public class App {
    
    public static void main(String[] args) {

        StringParser sParser = new StringParser();
        sParser.readInput("Mister Huu's addres is tattisuonkatu 4 A 123");
        sParser.parseText();
        System.out.println(sParser.getOriginalText());
        System.out.println(sParser.getParsedText());
    }

}
