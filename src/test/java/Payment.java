import java.util.Collections;
import java.util.List;

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
        if (! this.category.equals(other.category))
            throw new IllegalArgumentException(String.format("Cannot sum %s to %s since they have different categories", this, other));
        return new Payment(this.price + other.price, this.category);
    }
}

class Payments {
    private final List<Payment> currentMonthPayment;
    private final List<Payment> lastMonthPayment;

    public Payments(List<Payment> currentMonthPayment, List<Payment> lastMonthPayment) {
        this.currentMonthPayment = currentMonthPayment;
        this.lastMonthPayment = lastMonthPayment;
    }

    public Payments() {
        this(Collections.emptyList(), Collections.emptyList());
    }

    public static Payments noPayments() {
        return new Payments();
    }

    boolean isCurrPaymentTooHigh() {
        if (currentMonthPayment.isEmpty())
            return false;

        if (lastMonthPayment.isEmpty())
            return true;

        Payment currPayment = totalCurrentPayment();
        Payment lastPayment = lastMonthPayment.get(0);
        int currPrice = currPayment.price();
        int lastPrice = lastPayment.price();
        double lastPriceThreshold = lastPrice * 1.5;
        return (currPrice > lastPriceThreshold);
    }

    private Payment totalPayment(List<Payment> paymentList) {
        if (paymentList.isEmpty())
            return new Payment(0, Category.ENTERTAINMENT);

        if (paymentList.size() == 1)
            return paymentList.get(0);

        return paymentList.get(0).plus(paymentList.get(1));
    }

    public Payment totalCurrentPayment() {
        return totalPayment(currentMonthPayment);
    }
}
