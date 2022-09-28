package exes.spending;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PaymentFetcherStub implements PaymentFetcher {
    private List<Payment> currentMonthPayments = List.of();
    private List<Payment> prevMonthPayments = List.of();

    @Override
    public Payments fetchPaymentsFor(String user) {
        return new Payments(currentMonthPayments, prevMonthPayments);
    }

    public void returnSpendings(List<Payment> currentMonthPayments, List<Payment> prevMonthPayments) {
        this.currentMonthPayments = currentMonthPayments;
        this.prevMonthPayments = prevMonthPayments;
    }
}

class MailSenderMock implements MailSender {
    private Mail mail = null;

    @Override
    public void sendMail(Mail mail) {
        this.mail = mail;
    }

    public void verifyNoMailSent() {
        assertNull(mail);
    }

    public void verifyMailSent(String price, String category) {
        assertNotNull(mail);
        assertTrue(mail.text().contains(price));
        assertTrue(mail.text().contains(category));
    }

    public void verifyTotalInMailSubject(String total) {
        assertTrue(mail.subject().contains(total));
    }
}
