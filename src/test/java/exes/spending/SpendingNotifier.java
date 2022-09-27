package exes.spending;

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

//        for (exes.spending.Category category: exes.spending.Category.values()) {
//            if (payments.isCurrPaymentTooHighFor(category)) {
//                mail.add(payments.totalCurrentPaymentFor(category));
//            }
//        }

        mail = new Mail(payments.findHighest());

        if (mail.hasAtLeastOnePayment())
            mailSender.sendMail(mail);
    }
}
