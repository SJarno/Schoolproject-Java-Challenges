package numberstostring;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
    private StringParser stringParser;
    private String path;
    private String filename;

    public FileHandler(String filename) {
        this.stringParser = new StringParser();
        this.path = "Haaste7\\challengeseven\\src\\main\\java\\numberstostring\\";
        this.filename = filename;
    }
    public void readFromFile() {
        StringBuilder sb = new StringBuilder();
        try {
            Files.lines(Paths.get(path+filename)).forEach(sb::append);
        } catch (IOException ioException) {
            System.out.println(ioException);
        }
        stringParser.readInput(sb.toString());
        
    }
    public String getOriginalText() {
        return stringParser.getOriginalText();
    }
    public void parseOriginalText() {
        stringParser.parseText();
    }
    public String getParsedText() {
        return stringParser.getParsedText();
    }
    public void writeToFile() {

    }
    
    
}
