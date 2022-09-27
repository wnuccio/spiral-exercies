package exes.spending;

public interface PaymentFetcher {
    Payments fetchPaymentsFor(String user);
}
