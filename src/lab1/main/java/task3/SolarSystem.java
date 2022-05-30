package task3;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SolarSystem {
    private String name;
    private List<ISpaceObject> objects = new ArrayList<>();

    public SolarSystem(String name) {
        this.name = name;
    }

    public Double getWeight() {
        Double mass = 0.0;
        for (ISpaceObject s : objects) mass += s.getWeight();
        return mass;
    }

    protected void removeSpaceObject(ISpaceObject spaceObject) {
        this.objects.remove(spaceObject);
    }

    protected void addSpaceObject(ISpaceObject spaceObject) {
        spaceObject.setSolarSystem(this);
        this.objects.add(spaceObject);
    }

    public List<Planet> getPlanets(){
        List<Planet> planets = new ArrayList<>();
        for (ISpaceObject s : objects){
            if (s instanceof Planet) planets.add((Planet) s);
        }
        return planets;
    }
}
