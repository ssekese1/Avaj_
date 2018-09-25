package org.project.avaj_launcher.tower;

import org.project.avaj_launcher.Flyable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tower{


   private static List<Flyable> observers = new ArrayList<>();


    public void register(Flyable flyable)
    {
            observers.add(flyable);
    }
    public static void WriteToFile(String str)
    {

        FileWriter fileWriter;
        File file;
        try {
             file = new  File("simulation.txt");
            fileWriter = new FileWriter(file, true);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter.append(str);
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
        }
        catch(IOException e)
        {


        }
    }

    public void unregister(Flyable flyable)
    {
        if(observers.contains(flyable))
        observers.remove(flyable);
    }

    protected void conditionsChanged()
    {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}
