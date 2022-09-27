import java.util.Collections;

public class SpendingNotifier {
    private final PaymentFetcherStub paymentFetcher;
    private final MailSender mailSender;

    public SpendingNotifier(PaymentFetcherStub paymentFetcher, MailSender mailSender) {
        this.paymentFetcher = paymentFetcher;
        this.mailSender = mailSender;
    }

    public void notifyUnusualSpendingFor(String user) {
        Payments payments = paymentFetcher.fetchPaymentsFor(user);

//        List<Payment> highPayments = new ArrayList<>();

        Mail mail = new Mail();
        if (payments.isCurrPaymentTooHigh(Category.ENTERTAINMENT)) {
            mail.add(payments.totalCurrentPayment(Category.ENTERTAINMENT));
//            sendMailForPayment(payments.totalCurrentPayment(Category.ENTERTAINMENT));
        }

        if (payments.isCurrPaymentTooHigh(Category.RESTAURANTS)) {
            mail.add(payments.totalCurrentPayment(Category.RESTAURANTS));
//            sendMailForPayment(payments.totalCurrentPayment(Category.RESTAURANTS));
        }

        if (mail.isNotEmpty())
            mailSender.sendMail(mail);
    }

    private void sendMailForPayment(Payment payment) {
        mailSender.sendMail(new Mail(Collections.singletonList(payment)));

    }
}
