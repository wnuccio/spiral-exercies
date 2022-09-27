class Payment {
    private final int price;
    private final Category category;

    public Payment(int price, Category category) {
        this.price = price;
        this.category = category;
    }

    public int price() {
        return price;
    }

    public Category category() {
        return category;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "price=" + price +
                ", category=" + category +
                '}';
    }

    public Payment plus(Payment other) {
        if (!this.category.equals(other.category))
            throw new IllegalArgumentException(String.format("Cannot sum %s to %s since they have different categories", this, other));
        return new Payment(this.price + other.price, this.category);
    }

    public boolean muchGreaterThan(Payment other) {
        return (this.price() > other.price() * 1.5);

    }

}

