package org.project.avaj_launcher.simulator;
import java.io.*;
import java.util.*;
import org.project.avaj_launcher.Flyable;
import org.project.avaj_launcher.aircraft.AircraftFactory;
import org.project.avaj_launcher.tower.WeatherTower;




public class Main
{

    public static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args)
    {

        try {


            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String st = br.readLine();

            if (st != null) {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(st.split(" ")[0]);
                if (simulations < 0) {
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }

                System.out.println("Adding aircrafts:");
                while ((st = br.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(st.split(" ")[0], st.split(" ")[1],
                            Integer.parseInt(st.split(" ")[2]), Integer.parseInt(st.split(" ")[3]),
                            Integer.parseInt(st.split(" ")[4]));
                    flyables.add(flyable);
                }
               weatherTower.WriteToFile("Number of aircrafts: " + flyables.size());

                for (Flyable flyable : flyables)
                    flyable.registerTower(weatherTower);
                for (int i = 1; i <= simulations; i++)
                {
                    weatherTower.changeWeather();
                }

            }
            br.close();

        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found " + args[0]);
        }
        catch(IOException e)
        {
            System.out.println("Could not read from file " + args[0]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Please specify simulation file");
        }
        catch (NullPointerException e)
        {
            //System.out.println("value is null");
        }
    }
}

