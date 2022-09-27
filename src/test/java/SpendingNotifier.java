public class SpendingNotifier {
    private final PaymentFetcherStub paymentFetcher;
    private final MailSender mailSender;

    public SpendingNotifier(PaymentFetcherStub paymentFetcher, MailSender mailSender) {
        this.paymentFetcher = paymentFetcher;
        this.mailSender = mailSender;
    }

    public void notifyUnusualSpendingFor(String user) {
        Payments payments = paymentFetcher.fetchPaymentsFor(user);

        Mail mail = new Mail();
        if (payments.isCurrPaymentTooHigh(Category.ENTERTAINMENT)) {
            mail.add(payments.totalCurrentPayment(Category.ENTERTAINMENT));
        }

        if (payments.isCurrPaymentTooHigh(Category.RESTAURANTS)) {
            mail.add(payments.totalCurrentPayment(Category.RESTAURANTS));
        }

        if (mail.hasAtLeastOnePayment())
            mailSender.sendMail(mail);
    }
}
