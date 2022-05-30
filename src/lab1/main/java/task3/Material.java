package task3;


public enum Material {
    GOLD("Золотой"),
    PLATINUM("Платиновый"),
    RUBBER("Резиновый");

    private final String name;

    Material(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
