package exes.spending;

import org.junit.jupiter.api.Test;

import java.util.List;

import static exes.spending.Category.*;
import static java.util.Collections.emptyList;

/*
You work at a credit card company and as a value-add they want to start providing alerts to users
when their spending in any particular category is higher than usual.

A exes.spending.Payment is a simple value object with a price, description, and category
A exes.spending.Category is an enumerable type of a collection of things like “entertainment”, “restaurants”, and “golf”
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

    private Payment price(int value, Category category) {
        return new Payment(new Price(value), category);
    }

    @Test
    void send_no_mail_for_no_current_month_spending() {
        paymentFetcher.returnSpendings(emptyList(), emptyList());

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyNoMailSent();
    }

    @Test
    void send_mail_for_no_last_month_spending() {
        List<Payment> currentMonthPayments = List.of(price(10, ENTERTAINMENT));
        List<Payment> lastMonthPayments = List.of();
        paymentFetcher.returnSpendings(currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyMailSent("10", "entertainment");
    }

    @Test
    void send_no_mail_if_current_spending_is_less_than_threshold() {
        List<Payment> currentMonthPayments = List.of(price(10, ENTERTAINMENT));
        List<Payment> lastMonthPayments = List.of(price(10, ENTERTAINMENT)); // threshold = 15

        paymentFetcher.returnSpendings(currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyNoMailSent();
    }

    @Test
    void send_no_mail_if_current_spending_is_equals_to_threshold() {
        List<Payment> currentMonthPayments = List.of(price(15, ENTERTAINMENT));
        List<Payment> lastMonthPayments = List.of(price(10, ENTERTAINMENT));

        paymentFetcher.returnSpendings(currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyNoMailSent();
    }

    @Test
    void send_mail_if_current_spending_is_greater_than_threshold() {
        List<Payment> currentMonthPayments = List.of(price(20, ENTERTAINMENT));
        List<Payment> lastMonthPayments = List.of(price(10, ENTERTAINMENT)); // threshold = 15
        paymentFetcher.returnSpendings(currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyMailSent("20", "entertainment");
    }

    @Test
    void send_mail_if_total_current_spending_is_greater_than_threshold() {
        List<Payment> currentMonthPayments = List.of(
                price(10, ENTERTAINMENT),
                price(10, ENTERTAINMENT));

        List<Payment> lastMonthPayments = List.of(
                price(10, ENTERTAINMENT));

        paymentFetcher.returnSpendings(currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyMailSent("20", "entertainment");
    }

    @Test
    void send_no_mail_if_total_current_spending_is_not_much_greater_than_total_last_spending() {
        List<Payment> currentMonthPayments = List.of(
                price(10, ENTERTAINMENT),
                price(10, ENTERTAINMENT),
                price(10, ENTERTAINMENT));

        // total with threshold: 20 * 1,5 = 30
        List<Payment> lastMonthPayments = List.of(
                price(10, ENTERTAINMENT),
                price(10, ENTERTAINMENT));

        paymentFetcher.returnSpendings(currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyNoMailSent();
    }

    @Test
    void send_mail_taking_into_account_categories() {
        List<Payment> currentMonthPayments = List.of(price(20, ENTERTAINMENT));
        List<Payment> lastMonthPayments = List.of(price(10, RESTAURANTS));
        paymentFetcher.returnSpendings(currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyMailSent("20", "entertainment");
    }

    @Test
    void send_mail_specifying_the_right_category() {
        List<Payment> currentMonthPayments = List.of(price(20, RESTAURANTS));
        List<Payment> lastMonthPayments = List.of();
        paymentFetcher.returnSpendings(currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyMailSent("20", "restaurants");
    }

    @Test
    void send_mail_specifying_the_right_categories() {
        List<Payment> currentMonthPayments = List.of(
                price(10, ENTERTAINMENT),
                price(20, RESTAURANTS)
        );
        List<Payment> lastMonthPayments = List.of();
        paymentFetcher.returnSpendings(currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyMailSent("10", "entertainment");
        mailSender.verifyMailSent("20", "restaurants");
    }

    @Test
    void send_mail_with_total_spending_in_subject() {
        List<Payment> currentMonthPayments = List.of(
                price(10, ENTERTAINMENT),
                price(20, RESTAURANTS),
                price(30, GOLF)
        );
        List<Payment> lastMonthPayments = List.of(
                price(10, RESTAURANTS),
                price(10, GOLF)
        );

        paymentFetcher.returnSpendings(currentMonthPayments, lastMonthPayments);

        SpendingNotifier spendingNotifier = new SpendingNotifier(paymentFetcher, mailSender);
        spendingNotifier.notifyUnusualSpendingFor("user1");

        mailSender.verifyTotalInMailSubject("60");
        mailSender.verifyMailSent("10", "entertainment");
        mailSender.verifyMailSent("20", "restaurants");
        mailSender.verifyMailSent("30", "golf");
    }
}
