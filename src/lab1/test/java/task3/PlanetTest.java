package task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlanetTest {
    @Test
    @DisplayName("Check planet name")
    public void checkName() {
        SolarSystem solarSystem = new SolarSystem("123");
        Planet planet = new Planet("qqqq", Material.GOLD, 1000.0, NatureCond.ERUPTION, solarSystem);
        assertEquals("qqqq", planet.getName());
        assertEquals(Material.GOLD, planet.getMaterial());
        assertEquals(NatureCond.ERUPTION, planet.getNatureCond());
        planet.setName("q123");
        assertEquals("q123", planet.getName());

        planet.setMaterial(Material.PLATINUM);
        assertEquals(Material.PLATINUM, planet.getMaterial());

        planet.setNatureCond(NatureCond.FLOOD);
        assertEquals(NatureCond.FLOOD, planet.getNatureCond());
    }

    @Test
    @DisplayName("Check planet material")
    public void checkMaterial() {
        SolarSystem solarSystem = new SolarSystem("123");
        Planet planet = new Planet("qqqq", Material.GOLD, 1000.0, NatureCond.ERUPTION, solarSystem);
        assertEquals("qqqq", planet.getName());
        assertEquals(Material.GOLD, planet.getMaterial());

        planet.setMaterial(Material.PLATINUM);
        assertEquals(Material.PLATINUM, planet.getMaterial());
    }

    @Test
    @DisplayName("Check planet NatureCond")
    public void checkNatureCond() {
        SolarSystem solarSystem = new SolarSystem("123");
        Planet planet = new Planet("qqqq", Material.GOLD, 1000.0, NatureCond.ERUPTION, solarSystem);
        assertEquals(NatureCond.ERUPTION, planet.getNatureCond());

        planet.setNatureCond(NatureCond.FLOOD);
        assertEquals(NatureCond.FLOOD, planet.getNatureCond());
    }

    @Test
    @DisplayName("Check planet SolarSystem")
    public void checkSolarSystem() {
        SolarSystem solarSystem = new SolarSystem("123");
        Planet planet = new Planet("qqqq", Material.GOLD, 1000.0, NatureCond.ERUPTION, solarSystem);
        assertEquals(solarSystem, planet.getSolarSystem());
    }
}
