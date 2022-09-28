package exes.spending;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mail {
    private final List<Payment> payments;

    public Mail(List<Payment> payments) {
        this.payments = new ArrayList<>();
        this.payments.addAll(payments);
    }

    public String subject() {
        return String.format("Unusual spending of %s detected!", Payments.totalPrice(payments).asString());
    }

    public String text() {
        return "Hello card user!\n\n" +
                "We have detected unusually high spending on your card in these categories:\n\n" +
                youSpendAll() +
                "\nLove,\n\nThe Credit Card Company\n";
    }

    private String youSpend(Payment payment) {
        return String.format("* You spent $%s on %s", payment.price(), payment.category().asName());
    }

    private String youSpendAll() {
        return payments.stream()
                .map(this::youSpend)
                .collect(Collectors.joining("/n"));
    }
}
