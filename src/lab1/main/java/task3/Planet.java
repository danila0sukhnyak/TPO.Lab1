package task3;

import lombok.Data;


@Data
public class Planet implements ISpaceObject {
    private String name;
    private Material material;
    private Double weight;
    private NatureCond natureCond;
    private SolarSystem solarSystem;

    public Planet(String name, Material material, Double weight, NatureCond natureCond, SolarSystem solarSystem) {
        this.name = name;
        this.material = material;
        this.weight = weight;
        this.natureCond = natureCond;
        this.solarSystem = solarSystem;
    }
}

