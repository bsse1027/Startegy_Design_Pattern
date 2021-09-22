package converterpattern;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JSON implements IStrategy {
    String[] text;
    String json = "";
    Path path;

    public JSON(String[] text){
        String localDir = System.getProperty("user.dir");
        this.text = text;
        this.path = Paths.get(localDir+
                "\\Output.txt");
    }

    public void convert(){
        String[] temp;
        json += "{\n";

        for (int i=0; i<text.length; i++){
            temp = text[i].split(" ", 0);

            json += "\t{\n";
            json += "id: " + temp[0];
            json += ",name: " + temp[1];
            json += ",designation: " + temp[2];
            json += "\n\t}";

            if(i != text.length-1) json += ",\n";
        }
        json += "\n}";

        try {
            Files.writeString(path, json, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
