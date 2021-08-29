package numberstostring;



public class App {
    
    public static void main(String[] args) {

        StringParser sParser = new StringParser();
        sParser.readInput(" ");
        sParser.parseText();
        System.out.println(sParser.getOriginalText());
        System.out.println(sParser.getParsedText());
    }

}
