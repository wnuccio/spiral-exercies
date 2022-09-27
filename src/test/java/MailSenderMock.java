import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PaymentFetcherStub implements PaymentFetcher {
    private List<Payment> currentMonthPayments;
    private List<Payment> prevMonthPayments;

    @Override
    public Payments fetchPaymentsFor(String user) {
        return new Payments(currentMonthPayments, prevMonthPayments);
    }

    public void returnSpendings(String user, List<Payment> currentMonthPayments, List<Payment> prevMonthPayments) {
        this.currentMonthPayments = currentMonthPayments;
        this.prevMonthPayments = prevMonthPayments;
    }
}

class MailSenderMock implements MailSender {


    private List<Mail> mails = new ArrayList<>();


    @Override
    public void sendMail(String user, String price, Category category) {
        mails.add(new Mail(user, price, category));
    }

    public void verifyNoMailSent() {
        assertEquals(0, mails.size());
    }

    public void verifyMailSent(String user, String price, String category) {
        assertEquals(1, mails.size());
        assertEquals(true, mails.get(0).text().contains(price));
        assertEquals(true, mails.get(0).text().contains(category));
    }
}
