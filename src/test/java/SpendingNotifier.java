public class SpendingNotifier {
    private PaymentFetcherStub paymentFetcher;
    private MailSender mailSender;

    public SpendingNotifier(PaymentFetcherStub paymentFetcher, MailSender mailSender) {
        this.paymentFetcher = paymentFetcher;
        this.mailSender = mailSender;
    }

    public void notifyUnusualSpendingFor(String user) {
        Payments payments = paymentFetcher.fetchPaymentsFor(user);
        if (payments.currentMonthPayment.isEmpty())
            return;

        Payment payment = payments.currentMonthPayment.get(0);
        String price = String.valueOf(payment.price());
        mailSender.sendMail(user, price, payment.category());
    }
}
