package task3;

public enum NatureCond {
    EARTHQUAKE("Землетрясение"),
    FLOOD("Наводнение"),
    ERUPTION("Извержение"),
    NOTHING("Ничего");

    private final String name;

    NatureCond(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
