package payment;

public class UPIPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using UPI");
    }
}