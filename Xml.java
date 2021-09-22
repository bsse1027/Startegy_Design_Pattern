package converterpattern;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Xml implements IStrategy {
    String[] text;
    String xml = "";
    Path path;

    public Xml(String[] text){
        String localDir = System.getProperty("user.dir");
        this.text = text;
        this.path = Paths.get(localDir+
                "\\Output.txt");
    }

    public void convert(){
        String[] temp;

        for (int i=0; i<text.length; i++){
            temp = text[i].split(" ", 0);

            //String temp2 = temp[2].substring(0, temp[2].length()-1);

            xml += "<Employee>";
            xml += "<id> " + temp[0] + " </id>";
            xml += "<name> " + temp[1] + " </name>";
            xml += "<designation> " + temp[2] + " </designation>";
            xml += "</Employee>\n";
        }

        try {
            Files.writeString(path, xml, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
