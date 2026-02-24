import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TemperatureApp extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Temperature Converter");

        Label titleLabel = new Label ("Temperature Converter");

        TextField temperatureField = new TextField();
        temperatureField.setPromptText("Enter temperature");

        ComboBox<String> unitBox = new ComboBox<>();
        unitBox.getItems().addAll("C", "F");
        unitBox.setValue("C");

        VBox root = new VBox(10, titleLabel, temperatureField, unitBox);

        Scene scene = new Scene(root, 400, 220);
        stage.setScene(scene);
        stage.show();
    }     
    public static void main(String[] args) {
        launch(args);
    }
}        
    
       