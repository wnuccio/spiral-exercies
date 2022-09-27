package exes.spending;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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

    public static Payments noPayment() {
        return new Payments();
    }

    private Payment total(List<Payment> paymentList, Category category) {
        return paymentList.stream()
                .filter(payment -> payment.category().equals(category))
                .reduce(new Payment(0, category), Payment::plus);
    }

    public List<Payment> findUnusuallyHighPaymentsForEachCategory() {
        return currentMonthPayment.stream()
                .collect(groupingBy(Payment::category))
                .entrySet().stream()
                .map(entry -> total(entry.getValue(), entry.getKey()))
                .filter(payment -> payment.atLeast50percentMoreThan(total(lastMonthPayment, payment.category())))
                .collect(Collectors.toList());
    }
}
