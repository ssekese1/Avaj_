package org.project.avaj_launcher.aircraft;

import org.project.avaj_launcher.Flyable;
import org.project.avaj_launcher.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable
{

    private WeatherTower weatherTower = new WeatherTower();


    //constructor
    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        switch (weatherTower.getWeather(this.coordinates))
        {

            case "RAIN":
            {
                weatherTower.WriteToFile("JetPlane#" + this.name + "(" + this.id + "): May day, May day...there's a heavy storm coming my way. Looks like rain...oh my word, its raining. Its been a while hey!! watch out for lightning guys!!");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                break;
            }

            case "SUN":
            {
                weatherTower.WriteToFile("Helicopter#" + this.name + "(" + this.id + "): Now this weather is perfect for the beach, can't wait till I get down, then I am off to the beach...to busk in the sun of course!!");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                break;
            }
            case "FOG":
            {
                weatherTower.WriteToFile("Helicopter#" + this.name + "(" + this.id + "): holy Molly, can hardly see, maybe the wipers will help, there's too much fog out here...gotta be careful, I mean very.");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                break;
            }
            case "SNOW":
            {
                weatherTower.WriteToFile("Helicopter#" + this.name + "(" + this.id + "): OH how I hate snow, pity I gotta do it...snowman, maybe you could help hey!?!");
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                break;
            }
    }

        if (coordinates.getHeight() <= 0)
        {
            weatherTower.WriteToFile("Tower says: JetPlane#" + this.name  + "(" + this.id + ")" +" landed and unregistered from tower.");

            this.weatherTower.unregister(this);
        }
        else if (coordinates.getHeight() > 100)
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        weatherTower.WriteToFile("Tower says: JetPlane#" + this.name  + "(" + this.id + ")" +" registered to weather tower.");

        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

}
