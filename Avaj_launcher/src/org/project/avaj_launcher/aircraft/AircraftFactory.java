package org.project.avaj_launcher.aircraft;

import org.project.avaj_launcher.Flyable;


public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
         Coordinates coordinates = new Coordinates (longitude,latitude,height);

      switch (type) {
          case "Baloon" : {
              return new Baloon(name, coordinates);
          }
          case "JetPlane" : {
              return new JetPlane(name, coordinates);
          }
          case "Helicopter":
          {
              return new Helicopter(name, coordinates);
          }
      }
      return null;
    }
}
