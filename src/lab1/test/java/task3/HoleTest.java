package task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HoleTest {

    @Test
    @DisplayName("Check hole name")
    public void checkName() {
        Hole hole = new Hole("q2e3", Color.WHITE, 100000.0);
        assertEquals("q2e3", hole.getName());
        hole.setName("qqqq");
        assertEquals("qqqq", hole.getName());
    }

    @Test
    @DisplayName("Check hole create function")
    public void checkCreate() {
        Hole hole = new Hole("q3e3", Color.WHITE, 100000.0);
        SolarSystem solarSystem = new SolarSystem("1234");
        solarSystem.addSpaceObject(hole);
        hole.create("11111", Material.PLATINUM, 100.0, NatureCond.EARTHQUAKE);
        assertEquals(100100, solarSystem.getWeight());
        assertEquals(1, solarSystem.getPlanets().size());
    }

    @Test
    @DisplayName("Check hole DELETE function")
    public void checkDelete() {
        Hole hole = new Hole("q4e3", Color.WHITE, 10000000.0);
        SolarSystem solarSystem = new SolarSystem("2234");
        solarSystem.addSpaceObject(hole);
        hole.create("12", Material.PLATINUM, 100.0, NatureCond.EARTHQUAKE);
        assertEquals(1, solarSystem.getPlanets().size());
        Hole hole1 = new Hole("q4e4", Color.BLACK, 100000.0);
        solarSystem.addSpaceObject(hole1);
        hole1.delete(solarSystem.getPlanets().get(0));
        assertEquals(0, solarSystem.getPlanets().size());
    }

    @Test
    @DisplayName("Check hole create function exception")
    public void checkCreateEx() {
        Hole hole = new Hole("q3e3", Color.BLACK, 100000.0);
        SolarSystem solarSystem = new SolarSystem("1234");
        solarSystem.addSpaceObject(hole);
        hole.create("11111", Material.PLATINUM, 100.0, NatureCond.EARTHQUAKE);
        assertEquals(0, solarSystem.getPlanets().size());
    }

    @Test
    @DisplayName("Check hole delete function exception")
    public void checkDeleteEx() {
        Hole hole = new Hole("q4e3", Color.WHITE, 10000000.0);
        SolarSystem solarSystem = new SolarSystem("2234");
        solarSystem.addSpaceObject(hole);
        hole.create("12", Material.PLATINUM, 100.0, NatureCond.EARTHQUAKE);
        assertEquals(1, solarSystem.getPlanets().size());
        Hole hole1 = new Hole("q4e4", Color.WHITE, 100000.0);
        solarSystem.addSpaceObject(hole1);
        hole1.delete(solarSystem.getPlanets().get(0));
        assertEquals(1, solarSystem.getPlanets().size());
    }

    @Test
    @DisplayName("Check hole Color And SolarSystem")
    public void checkColorAndSolarSystem() {
        Hole hole = new Hole("q3e3", Color.BLACK, 100000.0);
        SolarSystem solarSystem = new SolarSystem("1234");
        solarSystem.addSpaceObject(hole);

        assertEquals(Color.BLACK, hole.getColor());

        assertEquals(solarSystem, hole.getSolarSystem());

        SolarSystem solarSystem1 = new SolarSystem("12343");
        hole.setSolarSystem(solarSystem1);
        assertEquals(solarSystem1, hole.getSolarSystem());

        hole.setColor(Color.WHITE);
        assertEquals(Color.WHITE, hole.getColor());

    }
}
