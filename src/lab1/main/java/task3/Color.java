package task3;


public enum Color {
    BLACK("Черный"),
    WHITE("Белый");

    private final String name;

    Color(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
