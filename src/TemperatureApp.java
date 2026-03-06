import java.util.Scanner;

/**
 * Main application for temperature conversion
 */
public class TemperatureApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");

        System.out.print("Enter temperature value: ");
        double value = scanner.nextDouble();

        System.out.print("Enter unit (C, F, K): ");
        String unit = scanner.next();

        if (!TemperatureValidator.isValidUnit(unit)) {
            System.out.println("Invalid unit.");
            return;
        }

        double result;

        if (unit.equalsIgnoreCase("C")) {
            result = TemperatureConverter.celsiusToFahrenheit(value);
            System.out.println(value + " C = " + result + " F");
        }

        else if (unit.equalsIgnoreCase("F")) {
            result = TemperatureConverter.fahrenheitToCelsius(value);
            System.out.println(value + " F = " + result + " C");
        }

        else {
            if (!TemperatureValidator.isValidKelvin(value)) {
                System.out.println("Kelvin cannot be negative.");
                return;
            }

            result = TemperatureConverter.kelvinToCelsius(value);
            System.out.println(value + " K = " + result + " C");
        }

        scanner.close();
    }
}