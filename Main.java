package converterpattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Context Conv = new Context();

        primaryStage.setTitle("Convert your file to CSV/XML/JSON");
        String localDir = System.getProperty("user.dir");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(
                localDir));

        VBox vBox = new VBox();

        Label label = new Label("Please select an input file before Conversion");

        Button chooseFile = new Button("Choose an input File");
        Button JsonButton = new Button("JSON Conversion");
        Button xmlButton = new Button("XML Conversion");
        Button csvButton = new Button("CSV Conversion");


        chooseFile.setStyle("-fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\n" +
                "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\n" +
                "    -fx-background-insets: 0,1,4,5;\n" +
                "    -fx-background-radius: 9,8,5,4;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: #333333;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        JsonButton.setStyle("-fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\n" +
                "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\n" +
                "    -fx-background-insets: 0,1,4,5;\n" +
                "    -fx-background-radius: 9,8,5,4;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: #333333;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        csvButton.setStyle("-fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\n" +
                "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\n" +
                "    -fx-background-insets: 0,1,4,5;\n" +
                "    -fx-background-radius: 9,8,5,4;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: #333333;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        xmlButton.setStyle("-fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\n" +
                "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\n" +
                "    -fx-background-insets: 0,1,4,5;\n" +
                "    -fx-background-radius: 9,8,5,4;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: #333333;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");


        EventHandler<ActionEvent> fileChoose = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File file = fileChooser.showOpenDialog(primaryStage);

                if (file != null) {
                    label.setText("Selected File: " + file.getName());
                    Conv.setFile(file);
                }
            }
        };

        EventHandler<ActionEvent> jsonEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(Conv.getMyStringArray() != null) {
                    Conv.setMyStrategy(new JSON(Conv.getMyStringArray()));
                    Conv.convert();
                }
            }
        };

        EventHandler<ActionEvent> csvEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(Conv.getMyStringArray() != null) {
                    Conv.setMyStrategy(new CSV(Conv.getMyStringArray()));
                    Conv.convert();
                }
            }
        };

        EventHandler<ActionEvent> xmlEvent = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(Conv.getMyStringArray() != null) {
                    Conv.setMyStrategy(new Xml(Conv.getMyStringArray()));
                    Conv.convert();
                }
            }
        };

        chooseFile.setOnAction(fileChoose);
        JsonButton.setOnAction(jsonEvent);
        csvButton.setOnAction(csvEvent);
        xmlButton.setOnAction(xmlEvent);

        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);

        vBox.getChildren().addAll(label, chooseFile, JsonButton, csvButton, xmlButton);

        primaryStage.setScene(new Scene(vBox, 500, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        //launch the application
        launch(args);
    }
}
