package exes.spending;

import java.util.List;

public class SpendingNotifier {
    private final PaymentFetcherStub paymentFetcher;
    private final MailSender mailSender;

    public SpendingNotifier(PaymentFetcherStub paymentFetcher, MailSender mailSender) {
        this.paymentFetcher = paymentFetcher;
        this.mailSender = mailSender;
    }

    public void notifyUnusualSpendingFor(String user) {
        Payments payments = paymentFetcher.fetchPaymentsFor(user);

        List<Payment> highPayments = payments.findUnusuallyHighPaymentsForEachCategory();

        if (! highPayments.isEmpty())
            mailSender.sendMail(new Mail(highPayments));
    }
}
