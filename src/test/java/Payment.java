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
}

class Payments {
    List<Payment> currentMonthPayment;
    List<Payment> lastMonthPayment;

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

        Payment currPayment = currentMonthPayment.get(0);
        Payment lastPayment = lastMonthPayment.get(0);
        int currPrice = currPayment.price();
        int lastPrice = lastPayment.price();
        double lastPriceThreshold = lastPrice * 1.5;
        return (currPrice > lastPriceThreshold);
    }
}
