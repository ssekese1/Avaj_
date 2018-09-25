package org.project.avaj_launcher.aircraft;

import org.project.avaj_launcher.Flyable;
import org.project.avaj_launcher.simulator.Main;
import org.project.avaj_launcher.tower.Tower;
import org.project.avaj_launcher.tower.WeatherTower;

import java.io.IOException;

public class Baloon extends Aircraft implements Flyable
{

    private WeatherTower weatherTower = new WeatherTower();


    //constructor
    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather){
            case "RAIN" :
            {
                weatherTower.WriteToFile("Baloon#" + this.name + "(" + this.id + "): Flying in the rain...how amazing...but I am surely gonna catch a cold and mess up this baloon");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                break;
            }

           case "SUN":
            {
                weatherTower.WriteToFile("Baloon#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics guys.");
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                break;
            }

           case "FOG":
            {
                weatherTower.WriteToFile("Baloon#" + this.name + "(" + this.id + "): This is the only thing I hate about fog, can't enjoy the sight...I just miss the beauty of looking down from the sky.");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            }

            case "SNOW":
            {
                weatherTower.WriteToFile("Baloon#" + this.name + "(" + this.id + "): Its freezing out here, should have worn warmer clothes, this snow ain't for sissies.");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                break;
            }
        }
        if (coordinates.getHeight() <= 0)
        {
            weatherTower.WriteToFile("Tower says: Baloon#" + this.name  + "(" + this.id + ")" +"landed and unregistered from tower.");
            weatherTower.unregister(this);

        }
        else if (coordinates.getHeight() > 100)
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
        }
    }




    public void registerTower(WeatherTower weatherTower)
    {

        weatherTower.WriteToFile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

}
