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


        if (payments.lastMonthPayment.isEmpty()) {
            Payment currPayment = payments.currentMonthPayment.get(0);
            String price = String.valueOf(currPayment.price());
            mailSender.sendMail(user, price, currPayment.category());
            return;
        }

        Payment currPayment = payments.currentMonthPayment.get(0);
        Payment lastPayment = payments.lastMonthPayment.get(0);
        int currPrice = currPayment.price();
        int lastPrice = lastPayment.price();
        double lastPriceThreshold = lastPrice * 1.5;
        if (currPrice > lastPriceThreshold) {
            String price = String.valueOf(currPayment.price());
            mailSender.sendMail(user, price, currPayment.category());
        }

    }
}
