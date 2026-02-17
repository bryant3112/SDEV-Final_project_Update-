/**
 * Validates temperature values
 */
public class TemperatureValidator {

    public static boolean isValidUnit(String unit) {
        return unit.equalsIgnoreCase("C")
            || unit.equalsIgnoreCase("F")
            || unit.equalsIgnoreCase("K");
    }

    public static boolean isValidKelvin(double value) {
        return value >= 0;
    }
}