public class SpendingNotifier {
    private final PaymentFetcherStub paymentFetcher;
    private final MailSender mailSender;

    public SpendingNotifier(PaymentFetcherStub paymentFetcher, MailSender mailSender) {
        this.paymentFetcher = paymentFetcher;
        this.mailSender = mailSender;
    }

    public void notifyUnusualSpendingFor(String user) {
        Payments payments = paymentFetcher.fetchPaymentsFor(user);

        if (payments.isCurrPaymentTooHigh()) {
            sendMailForPayment(user, payments.totalCurrentPayment());
        }
    }

    private void sendMailForPayment(String user, Payment payment) {
        String price = String.valueOf(payment.price());
        mailSender.sendMail(user, price, payment.category());

    }
}
