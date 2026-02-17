public class TemperatureConverterTest {

    public static void main(String[] args) {

        assert TemperatureConverter.celsiusToFahrenheit(0) == 32;
        assert TemperatureConverter.fahrenheitToCelsius(32) == 0;
        assert TemperatureConverter.celsiusToKelvin(0) == 273.15;
        assert TemperatureConverter.kelvinToCelsius(273.15) == 0;

        System.out.println("TemperatureConverterTest passed.");
    }
}
