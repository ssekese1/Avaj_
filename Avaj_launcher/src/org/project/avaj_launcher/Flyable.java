package org.project.avaj_launcher;

import org.project.avaj_launcher.tower.WeatherTower;

public interface Flyable {

    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);
}
