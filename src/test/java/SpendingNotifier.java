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
        mailSender.sendMail(user, "10", Category.ENTERTAINMENT);
    }
}
