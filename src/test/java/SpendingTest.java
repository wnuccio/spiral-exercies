import org.junit.jupiter.api.Test;

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
    void send_no_mail_for_an_unknown_user() {
        List<Payment> currentMonthPayments = List.of(new Payment(10, Category.ENTERTAINMENT));

        paymentFetcher.returnSpendings("user1", currentMonthPayments, emptyList());

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user2");

        mailSender.verifyNoMailSent();
    }

    @Test
    void send_no_mail_for_no_current_month_spending() {
        paymentFetcher.returnSpendings("user1", emptyList(), emptyList());

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyNoMailSent();
    }

    @Test
    void send_mail_for_no_last_month_spending() {
        List<Payment> currentMonthPayments = List.of(new Payment(10, Category.ENTERTAINMENT));
        List<Payment> lastMonthPayments = List.of();
        paymentFetcher.returnSpendings("user1", currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyMailSent("user1", "10", "entertainment");
    }

    @Test
    void send_no_mail_if_current_spending_is_less_than_threshold() {
        List<Payment> currentMonthPayments = List.of(new Payment(10, Category.ENTERTAINMENT));
        List<Payment> lastMonthPayments = List.of(new Payment(10, Category.ENTERTAINMENT)); // threshold = 15

        paymentFetcher.returnSpendings("user1", currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyNoMailSent();
    }

    @Test
    void send_no_mail_if_current_spending_is_equals_to_threshold() {
        List<Payment> currentMonthPayments = List.of(new Payment(15, Category.ENTERTAINMENT));
        List<Payment> lastMonthPayments = List.of(new Payment(10, Category.ENTERTAINMENT));

        paymentFetcher.returnSpendings("user1", currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyNoMailSent();
    }

    @Test
    void send_mail_if_current_spending_is_greater_than_threshold() {
        List<Payment> currentMonthPayments = List.of(new Payment(20, Category.ENTERTAINMENT));
        List<Payment> lastMonthPayments = List.of(new Payment(10, Category.ENTERTAINMENT)); // threshold = 15
        paymentFetcher.returnSpendings("user1", currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyMailSent("user1", "20", "entertainment");
    }

    @Test
    void send_mail_if_total_current_spending_is_greater_than_threshold() {
        List<Payment> currentMonthPayments = List.of(
                new Payment(10, Category.ENTERTAINMENT),
                new Payment(10, Category.ENTERTAINMENT));

        List<Payment> lastMonthPayments = List.of(
                new Payment(10, Category.ENTERTAINMENT));

        paymentFetcher.returnSpendings("user1", currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyMailSent("user1", "20", "entertainment");
    }

    @Test
    void send_no_mail_if_total_current_spending_is_not_much_greater_than_total_last_spending() {
        List<Payment> currentMonthPayments = List.of(
                new Payment(10, Category.ENTERTAINMENT),
                new Payment(10, Category.ENTERTAINMENT),
                new Payment(10, Category.ENTERTAINMENT));

        // total with threshold: 20 * 1,5 = 30
        List<Payment> lastMonthPayments = List.of(
                new Payment(10, Category.ENTERTAINMENT),
                new Payment(10, Category.ENTERTAINMENT));

        paymentFetcher.returnSpendings("user1", currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyNoMailSent();
    }

//    @Test
    void send_no_mail_when_payments_are_about_different_categories() {
        List<Payment> currentMonthPayments = List.of(new Payment(20, Category.ENTERTAINMENT));
        List<Payment> lastMonthPayments = List.of(new Payment(10, Category.RESTAURANTS));
        paymentFetcher.returnSpendings("user1", currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyNoMailSent();
    }
}
