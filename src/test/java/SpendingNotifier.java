public class SpendingNotifier {
    private final PaymentFetcherStub paymentFetcher;
    private final MailSender mailSender;

    public SpendingNotifier(PaymentFetcherStub paymentFetcher, MailSender mailSender) {
        this.paymentFetcher = paymentFetcher;
        this.mailSender = mailSender;
    }

    public void notifyUnusualSpendingFor(String user) {
        Payments payments = paymentFetcher.fetchPaymentsFor(user);

        if (payments.isCurrPaymentTooHigh(Category.ENTERTAINMENT)) {
            sendMailForPayment(user, payments.totalCurrentPayment(Category.ENTERTAINMENT));
        }
    }

    private void sendMailForPayment(String user, Payment payment) {
        String price = String.valueOf(payment.price());
        Mail mail = new Mail(user, price, payment.category());
        mailSender.sendMail(mail);

    }
}
