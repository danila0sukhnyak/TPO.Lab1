package task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class SolarSystemTest {

    @Test
    @DisplayName("Check SolarSystem name")
    void checkSolarSystemName() {
        SolarSystem solarSystem = new SolarSystem("123");
        assertEquals("123", solarSystem.getName());
    }

    @Test
    @DisplayName("Check SolarSystemGetPlanet")
    void checkSolarSystemGetPlanet() {
        SolarSystem solarSystem = new SolarSystem("123");
        Planet planet = new Planet("qqqq", Material.GOLD, 1000.0, NatureCond.ERUPTION, solarSystem);
        Planet planet1 = new Planet("qq1q", Material.RUBBER, 10020.0, NatureCond.FLOOD, solarSystem);
        solarSystem.addSpaceObject(planet);
        solarSystem.addSpaceObject(planet1);
        assertTrue(solarSystem.getPlanets().contains(planet));
        assertTrue(solarSystem.getPlanets().contains(planet1));
    }

    @Test
    @DisplayName("Check SolarSystemAddSpaceObject")
    void checkSolarSystemAddSpaceObject() {
        SolarSystem solarSystem = new SolarSystem("123");
        Planet planet = new Planet("qqqq", Material.GOLD, 1000.0, NatureCond.ERUPTION, solarSystem);
        solarSystem.addSpaceObject(planet);
        assertTrue(solarSystem.getPlanets().contains(planet));
    }

    @Test
    @DisplayName("Check checkSolarSystemWeight")
    void checkSolarSystemWeight() {
        Hole hole = new Hole("qweqwe", Color.BLACK, 0.001);
        SolarSystem solarSystem = new SolarSystem("123");
        solarSystem.addSpaceObject(hole);
        assertEquals(0.001, solarSystem.getWeight());
    }


    @Test
    @DisplayName("Check checkSolarSystemWeight")
    void checkSolarSystemRemoveSpaceObject() {
        SolarSystem solarSystem = new SolarSystem("123");
        Planet planet = new Planet("qqqq", Material.GOLD, 11110.0, NatureCond.NOTHING, solarSystem);
        solarSystem.addSpaceObject(planet);
        solarSystem.removeSpaceObject(planet);
        assertEquals(0, solarSystem.getPlanets().size());
    }
}
