package org.project.avaj_launcher.weather;

import org.project.avaj_launcher.aircraft.Coordinates;

public class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};


    private WeatherProvider()
    {

    }

    public static WeatherProvider getProvider()
    {
        return weatherProvider;
    }

    public static String getCurrentWeather(Coordinates coordinates)
    {
        int index = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return (weather[index % 4]);
    }
}
