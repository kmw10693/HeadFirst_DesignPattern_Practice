public class CurrentSynthesisDisplay implements Observer, DisplayElement {

    private double average;
    private double minValue;
    private double maxValue;
    private WeatherData weatherData;

    public CurrentSynthesisDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Average: " + average + " ,minValue: " + minValue + " ,maxValue: " + maxValue);
    }

    @Override
    public void update() {
        initValue();
        compareValue();
        display();
    }

    private void initValue() {
        minValue = (minValue == 0) ? weatherData.getTemperature() : minValue;
        maxValue = (maxValue == 0) ? weatherData.getTemperature() : maxValue;
    }

    private void compareValue() {
        minValue = (minValue > weatherData.getTemperature()) ? weatherData.getTemperature() : maxValue;
        maxValue = (maxValue < weatherData.getTemperature()) ? weatherData.getTemperature() : maxValue;
        average = (minValue + maxValue) / 2;
    }

}
