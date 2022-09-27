import java.util.Collections;
import java.util.List;

class Payment {
    private int price;
    private Category category;

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
}
