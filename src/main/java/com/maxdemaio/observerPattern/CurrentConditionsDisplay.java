package com.maxdemaio.observerPattern;

// We impl observer so we can get updates from the WeatherData obj
// Also impl DisplayEle bc our API requires all display eles to impl this interface
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        // The constructor is passed the weatherData object (the Subject)
        // and we use it to register the display as an observer!!
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        // The display() method just prints out the most recent temp and humidity.
        System.out.println("Current Conditions Display received an update!:");
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        // When update() is called
        // we save the temp and humidity and call display().
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
