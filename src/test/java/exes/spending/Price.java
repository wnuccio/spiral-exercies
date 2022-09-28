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

    public boolean atLeast50percentMoreThan(Price other) {
        return (this.value > other.value * 1.5);
    }

    public String asString() {
        return "$" + value;
    }
}
