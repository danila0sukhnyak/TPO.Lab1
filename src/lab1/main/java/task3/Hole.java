package task3;

import lombok.Data;



@Data
public class Hole implements ISpaceObject {
    private String name;
    private Double weight;
    private Color color;
    private SolarSystem solarSystem;

    public Hole(String name, Color color, Double weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public void create(String name, Material material, Double weight, NatureCond natureCond) {
        if (solarSystem != null) {
            if (color == Color.WHITE) {
                this.solarSystem.addSpaceObject(new Planet(name, material, weight, natureCond, this.solarSystem));
            } else {
                System.out.println("Неверный тип дыры");
            }
        }
    }

    public void delete(Planet planet) {
        if (solarSystem != null) {
            if (color == Color.BLACK) {
                this.solarSystem.removeSpaceObject(planet);
            } else {
                System.out.println("Неверный тип дыры");
            }
        }
    }
}