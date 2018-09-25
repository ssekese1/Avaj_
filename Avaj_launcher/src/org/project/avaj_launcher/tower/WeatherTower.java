package org.project.avaj_launcher.tower;


import org.project.avaj_launcher.aircraft.Coordinates;
import org.project.avaj_launcher.weather.WeatherProvider;


public class WeatherTower extends Tower {

    //instance field
    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    public void changeWeather()
    {
        this.conditionsChanged();
    }
}