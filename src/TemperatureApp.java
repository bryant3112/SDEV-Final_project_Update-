import java.util.Scanner;

/**
 * Console-based temperature application
 */
public class TemperatureApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double value = scanner.nextDouble();

        System.out.print("Enter unit (C, F, K): ");
        String unit = scanner.next();

        if (!TemperatureValidator.isValidUnit(unit)) {
            System.out.println("Invalid temperature unit.");
            return;
        }

        Temperature temp = new Temperature(value, unit);

        if (temp.getUnit().equals("C")) {
            System.out.println("Fahrenheit: " +
                TemperatureConverter.celsiusToFahrenheit(value));
            System.out.println("Kelvin: " +
                TemperatureConverter.celsiusToKelvin(value));
        }
        else if (temp.getUnit().equals("F")) {
            System.out.println("Celsius: " +
                TemperatureConverter.fahrenheitToCelsius(value));
        }
        else if (temp.getUnit().equals("K")) {
            if (!TemperatureValidator.isValidKelvin(value)) {
                System.out.println("Kelvin cannot be negative.");
                return;
            }
            System.out.println("Celsius: " +
                TemperatureConverter.kelvinToCelsius(value));
        }

        scanner.close();
    }
}
