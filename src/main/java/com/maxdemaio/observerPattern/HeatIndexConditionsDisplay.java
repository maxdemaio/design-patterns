package com.maxdemaio.observerPattern;

public class HeatIndexConditionsDisplay implements Observer, DisplayElement {
    private float heatIndex;
    private Subject weatherData;

    public HeatIndexConditionsDisplay(Subject weatherData) {
        // The constructor is passed the weatherData object (the Subject)
        // and we use it to register the display as an observer!!
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        // The display() method just prints out the most recent temp and humidity.
        System.out.println("Heat Index Display received an update!:");
        System.out.println("Current heat index: " + heatIndex);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        // When update() is called
        // we save the heatIndex (calc'ing it) and call display().
        this.heatIndex = (float) (-42.379 + 2.04901523*temperature + 10.14333127*humidity - .22475541*temperature*humidity - .00683783*temperature*temperature - .05481717*humidity*humidity + .00122874*temperature*temperature*humidity + .00085282*temperature*humidity*humidity - .00000199*temperature*temperature*humidity*humidity);
        display();
    }
}
