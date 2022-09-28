package exes.spending;

public class Price {
    private final int value;

    public Price(int value) {
        if (value < 0)
            throw new IllegalArgumentException("Negative price not allowed: " + value);

        this.value = value;
    }

    public Price plus(Price other) {
        return new Price(this.value + other.value);
    }

    public String asString() {
        return "$" + value;
    }
}
