public enum Category {
    RESTAURANTS("restaurants"), ENTERTAINMENT("entertainment");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String asName() {
        return name;
    }
}
