package org.project.avaj_launcher.aircraft;

import org.project.avaj_launcher.Flyable;
import org.project.avaj_launcher.simulator.Main;
import org.project.avaj_launcher.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable
{

    private WeatherTower weatherTower = new WeatherTower();

    //constructor
    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions() {
        switch (weatherTower.getWeather(this.coordinates)) {

            case "RAIN":
            {
                weatherTower.WriteToFile("Helicopter#" + this.name + "(" + this.id + "): Turn on the windscreen wipers gents, this is some heavy rain out here...!!");
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                break;
            }
            case "SUN":
            {
                weatherTower.WriteToFile("Helicopter#" + this.name + "(" + this.id + "): Ahh ITS A BEAUTIFUL DAY! Birds singing in the sky...melodious!!");
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                break;
            }
            case "FOG":
            {
                weatherTower.WriteToFile("Helicopter#" + this.name + "(" + this.id + "): This is some foggy weather, gotta be careful up there gents.");
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                break;
            }
            case "SNOW":
            {
                weatherTower.WriteToFile("Helicopter#" + this.name + "(" + this.id + "): Its that time of the year guys, I see snow...Its Xmas time...oh oh oh!!");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                break;
            }

        }

        if (coordinates.getHeight() <= 0)
        {
            weatherTower.WriteToFile("Tower says: Helicopter#" + this.name  + "(" + this.id + ")" +"landed and unregistered from tower.");

            this.weatherTower.unregister(this);
        }
        else if (coordinates.getHeight() > 100)
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        weatherTower.WriteToFile("Tower says: Helicopter#" + this.name  + "(" + this.id + ")" +" registered to weather tower.");
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
