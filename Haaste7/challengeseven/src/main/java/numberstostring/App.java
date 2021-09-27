package numberstostring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        /*
         * StringParser sParser = new StringParser(); sParser.readInput("7 on 7");
         * sParser.parseText(); System.out.println(sParser.getOriginalText());
         * System.out.println(sParser.getParsedText());
         */
        
         FileHandler fileHandler = new FileHandler("testi.txt");
         fileHandler.readFromFile();
         System.out.println(fileHandler.getOriginalText());
         fileHandler.parseOriginalText();
         System.out.println(fileHandler.getParsedText());
         /* String testi = "7. 7. 7.";
         System.out.println(testi.replace(".", "_.")); */
         
        

    }

    public static void basicRead(String path, String filename) {
        try (Scanner scanner = new Scanner(Paths.get(path + filename))) {
            while (scanner.hasNextLine()) {
                String rivi = scanner.nextLine();
                System.out.println(rivi);
            }
        } catch (Exception e) {
            System.out.println("Virhe tiedoston lukemisessa");
        }
    }

}
