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

        Payment currPayment = payments.currentMonthPayment.get(0);

        if (payments.lastMonthPayment.isEmpty()) {
            String price = String.valueOf(currPayment.price());
            mailSender.sendMail(user, price, currPayment.category());
        }
    }
}
