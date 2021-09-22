package converterpattern;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSV implements IStrategy {
    String[] text;
    String csv = "";
    Path path;
    String localDir = System.getProperty("user.dir");

    public CSV(String[] text){
        this.text = text;
        this.path = Paths.get(localDir+
                "\\Output.txt");
    }

    public void convert(){
        String[] temp;

        for (int i=0; i<text.length; i++){
            temp = text[i].split(" ", 0);

            csv += temp[0] + ",";
            csv += temp[1] + ",";
            csv += temp[2] + "\n";

        }

        try {
            Files.writeString(path, csv, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
