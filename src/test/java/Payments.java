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

    boolean isCurrPaymentTooHigh() {
        Payment totalLastPayment = totalPayment(lastMonthPayment);
        return totalCurrentPayment().muchGreaterThan(totalLastPayment);
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
