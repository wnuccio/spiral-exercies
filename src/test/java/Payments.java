import java.util.Collections;
import java.util.List;

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

    boolean isCurrPaymentTooHighFor(Category category) {
        Payment totalLastPayment = totalPayment(lastMonthPayment, category);
        return totalCurrentPayment(category).muchGreaterThan(totalLastPayment);
    }

    private Payment totalPayment(List<Payment> paymentList, Category category) {
        return paymentList.stream()
                .filter(payment -> payment.category().equals(category))
                .reduce(Payment::plus)
                .orElse(new Payment(0, category));
    }

    public Payment totalCurrentPayment(Category category) {
        return totalPayment(currentMonthPayment, category);
    }
}
