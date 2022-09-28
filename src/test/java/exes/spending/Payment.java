package exes.spending;

class Payment {
    private final Price price;
    private final Category category;

    public Payment(Price price, Category category) {
        this.price = price;
        this.category = category;
    }

    public Price price() {
        return price;
    }

    public Category category() {
        return category;
    }

    @Override
    public String toString() {
        return "exes.spending.Payment{" +
                "price=" + price +
                ", category=" + category +
                '}';
    }

    public Payment plus(Payment other) {
        if (!this.category.equals(other.category))
            throw new IllegalArgumentException(String.format("Cannot sum %s to %s since they have different categories", this, other));
        return new Payment(this.price.plus(other.price), this.category);
    }

    public boolean atLeast50percentMoreThan(Payment other) {
        return this.price().atLeast50percentMoreThan(other.price());
    }

}

