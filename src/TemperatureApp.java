import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX GUI application for converting temperatures.
 * This class connects the GUI to the Temperature logic classes.
 */
public class TemperatureApp extends Application {

    @Override
    public void start(Stage stage) {

        // Window title
        stage.setTitle("Temperature Converter");

        // Title label
        Label titleLabel = new Label("Temperature Converter");

        // Input field for temperature value
        TextField temperatureField = new TextField();
        temperatureField.setPromptText("Enter temperature");

        // Dropdown for unit selection
        ComboBox<String> unitBox = new ComboBox<>();
        unitBox.getItems().addAll("C", "F");
        unitBox.setValue("C");

        // Buttons
        Button convertButton = new Button("Convert");
        Button clearButton = new Button("Clear");

        // Label to display results
        Label resultLabel = new Label("Result will appear here");

        // ---------- EVENT #1: Convert Button ----------
        convertButton.setOnAction(e -> {
            try {
                double value = Double.parseDouble(temperatureField.getText());
                String unit = unitBox.getValue();

                // Validate unit
                if (!TemperatureValidator.isValidUnit(unit)) {
                    resultLabel.setText("Invalid unit selected");
                    return;
                }

                // Create Temperature object
                Temperature temp = new Temperature(value, unit);

                // Convert temperature
                Temperature converted = TemperatureConverter.convert(temp);

                // Display result
                resultLabel.setText(
                        "Converted: " + converted.getValue() + " " + converted.getUnit()
                );

            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number");
            }
        });

        // ---------- EVENT #2: Clear Button ----------
        clearButton.setOnAction(e -> {
            temperatureField.clear();
            unitBox.setValue("C");
            resultLabel.setText("Result will appear here");
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                titleLabel,
                temperatureField,
                unitBox,
                convertButton,
                clearButton,
                resultLabel
        );

        // Scene setup
        Scene scene = new Scene(layout, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    // Launch application
    public static void main(String[] args) {
        launch(args);
    }
}
