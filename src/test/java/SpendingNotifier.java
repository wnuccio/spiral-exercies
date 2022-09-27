public class SpendingNotifier {
    private final PaymentFetcherStub paymentFetcher;
    private final MailSender mailSender;

    public SpendingNotifier(PaymentFetcherStub paymentFetcher, MailSender mailSender) {
        this.paymentFetcher = paymentFetcher;
        this.mailSender = mailSender;
    }

    public void notifyUnusualSpendingFor(String user) {
        Payments payments = paymentFetcher.fetchPaymentsFor(user);
        if (payments.currentMonthPayment.isEmpty())
            return;


        if (payments.lastMonthPayment.isEmpty()) {
            Payment currPayment = payments.currentMonthPayment.get(0);
            sendMailForPayment(user, currPayment);
            return;
        }

        Payment currPayment = payments.currentMonthPayment.get(0);
        Payment lastPayment = payments.lastMonthPayment.get(0);
        int currPrice = currPayment.price();
        int lastPrice = lastPayment.price();
        double lastPriceThreshold = lastPrice * 1.5;
        if (currPrice > lastPriceThreshold) {
            sendMailForPayment(user, currPayment);
        }
    }

    private void sendMailForPayment(String user, Payment payment) {
        String price = String.valueOf(payment.price());
        mailSender.sendMail(user, price, payment.category());

    }
}
