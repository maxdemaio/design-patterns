package com.maxdemaio.observerPattern;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList observers; // holds observers
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList(); // empty on construction
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o); // when observer registers, add it to eol
    }

    @Override
    public void removeObserver(Observer o) {
        // when observer wants to un-register, rm from list
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        // where we tell all the observers about the state
        // bc they're all observers, they have the update() method
        // so we know how to notify them
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        // notify observers when we get an update
        // from the weather station
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        // we could read from an API here but we will just set them in code
        // for this example to display that the notifying is working
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // other weather data methods could go here
}
