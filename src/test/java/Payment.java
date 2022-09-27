import java.util.List;

class Payment {
    public Payment(int price, Category category) {

    }
}

class Payments {
    List<Payment> currentMonthPayment;
    List<Payment> lastMonthPayment;

    public Payments(List<Payment> currentMonthPayment, List<Payment> lastMonthPayment) {
        this.currentMonthPayment = currentMonthPayment;
        this.lastMonthPayment = lastMonthPayment;
    }
}
