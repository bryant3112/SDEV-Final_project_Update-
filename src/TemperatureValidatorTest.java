public class TemperatureValidatorTest {

    public static void main(String[] args) {

        assert TemperatureValidator.isValidUnit("C");
        assert TemperatureValidator.isValidUnit("F");
        assert TemperatureValidator.isValidUnit("K");
        assert !TemperatureValidator.isValidUnit("X");

        assert TemperatureValidator.isValidKelvin(0);
        assert !TemperatureValidator.isValidKelvin(-5);

        System.out.println("TemperatureValidatorTest passed.");
    }
}