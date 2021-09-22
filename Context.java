package converterpattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Context {
    private IStrategy myStrategy;
    private BufferedReader myBufferedReader;
    private String[] myStringArray;

    public void setMyStrategy(IStrategy strategy) {
        this.myStrategy = strategy;
    }

    public void setFile(File myFile) {
        try {
            myBufferedReader = new BufferedReader(new FileReader(myFile));

            int number = 0;
            char character;
            String data = "";

            while ((number = myBufferedReader.read()) != -1){
                character = (char) number;
                data += character;
            }

            myStringArray = data.split("\n", 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convert() {
        try {
            myStrategy.convert();

            myBufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public String[] getMyStringArray() {
        return myStringArray;
    }

}
