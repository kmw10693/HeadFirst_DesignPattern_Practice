public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        CurrentSynthesisDisplay currentSynthesisDisplay = new CurrentSynthesisDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 30.4f);
        weatherData.setMeasurements(78, 90, 30.4f);

    }
}
