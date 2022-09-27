import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PaymentFetcherStub implements PaymentFetcher {
    private String user = "";
    private List<Payment> currentMonthPayments = List.of();
    private List<Payment> prevMonthPayments = List.of();

    @Override
    public Payments fetchPaymentsFor(String user) {
        if ( ! this.user.equals(user))
            return Payments.noPayments();

        return new Payments(currentMonthPayments, prevMonthPayments);
    }

    public void returnSpendings(String user, List<Payment> currentMonthPayments, List<Payment> prevMonthPayments) {
        this.user = user;
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
        assertEquals(true, mail.text().contains(price));
        assertEquals(true, mail.text().contains(category));
    }
}
