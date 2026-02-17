public class TemperatureTest {

    public static void main(String[] args) {
        Temperature temp = new Temperature(25, "c");

        assert temp.getValue() == 25;
        assert temp.getUnit().equals("C");

        temp.setValue(30);
        temp.setUnit("f");

        assert temp.getValue() == 30;
        assert temp.getUnit().equals("F");

        System.out.println("TemperatureTest passed.");
    }
}