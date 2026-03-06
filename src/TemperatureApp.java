import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main JavaFX application for Temperature Converter
 */
public class TemperatureApp extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Temperature Converter");

        Label titleLabel = new Label("Temperature Converter");

        TextField temperatureField = new TextField();
        temperatureField.setPromptText("Enter temperature");

        ComboBox<String> unitBox = new ComboBox<>();
        unitBox.getItems().addAll("C", "F", "K");
        unitBox.setValue("C");

        Button convertButton = new Button("Convert");

        Label resultLabel = new Label("Result will appear here");

        convertButton.setOnAction(e -> {

            try {

                double value = Double.parseDouble(temperatureField.getText());
                String unit = unitBox.getValue();

                double result;

                if (unit.equals("C")) {
                    result = TemperatureConverter.celsiusToFahrenheit(value);
                    resultLabel.setText(value + " C = " + result + " F");
                }

                else if (unit.equals("F")) {
                    result = TemperatureConverter.fahrenheitToCelsius(value);
                    resultLabel.setText(value + " F = " + result + " C");
                }

                else {
                    result = TemperatureConverter.kelvinToCelsius(value);
                    resultLabel.setText(value + " K = " + result + " C");
                }

            } catch (Exception ex) {
                resultLabel.setText("Invalid number entered.");
            }

        });

        VBox root = new VBox(10,
                titleLabel,
                temperatureField,
                unitBox,
                convertButton,
                resultLabel);

        Scene scene = new Scene(root, 400, 250);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}