import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

/*
You work at a credit card company and as a value-add they want to start providing alerts to users
when their spending in any particular category is higher than usual.

A Payment is a simple value object with a price, description, and category
A Category is an enumerable type of a collection of things like “entertainment”, “restaurants”, and “golf”
For a given userId, fetch the payments for the current month and the previous month
Compare the total amount paid for the each month, grouped by category; filter down to the categories
for which the user spent at least 50% more this month than last month
Compose an e-mail message to the user that lists the categories for which spending was unusually high,
with a subject like “Unusual spending of $1076 detected!” and this body:

Hello card user!

We have detected unusually high spending on your card in these categories:

* You spent $148 on groceries
* You spent $928 on travel

Love,

The Credit Card Company
 */
public class SpendingTest {
    MailSenderMock mailSender = new MailSenderMock();
    PaymentFetcherStub paymentFetcher = new PaymentFetcherStub();

    @Test
    void send_no_mail_for_no_spending() {
        paymentFetcher.returnSpendings("user1", emptyList(), emptyList());

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyNoMailSent();
    }

    @Test
    void send_mail_on_unusual_spending_in_entertainment() {
        List<Payment> currentMonthPayments = Arrays.asList(
                new Payment(10, Category.ENTERTAINMENT)
        );

        paymentFetcher.returnSpendings("user1", currentMonthPayments, emptyList());

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyMailSent("user1", "10", "entertainment");
    }

    @Test
    void send_no_mail_for_an_unknown_user() {
        List<Payment> currentMonthPayments = Arrays.asList(
                new Payment(10, Category.ENTERTAINMENT)
        );

        paymentFetcher.returnSpendings("user1", currentMonthPayments, emptyList());

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user2");

        mailSender.verifyNoMailSent();
    }
}
