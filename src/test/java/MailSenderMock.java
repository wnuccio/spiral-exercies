import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailSenderMock implements MailSender {
    private List<Mail> mails = new ArrayList<>();


    public void returnSpendings(String user, List<Payment> currentMonthPayments, List<Payment> prevMonthPayments) {
    }

    public void verifyNoMailSent() {
        assertEquals(0, mails.size());
    }
}
