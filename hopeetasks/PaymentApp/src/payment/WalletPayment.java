package payment;

public class WalletPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Wallet");
    }
}