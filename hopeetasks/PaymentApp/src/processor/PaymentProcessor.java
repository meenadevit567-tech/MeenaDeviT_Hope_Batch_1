package processor;

import payment.PaymentMethod;

public class PaymentProcessor {

    public void process(PaymentMethod method, double amount) {
        method.pay(amount);
        System.out.println("Payment Successful");
    }
}