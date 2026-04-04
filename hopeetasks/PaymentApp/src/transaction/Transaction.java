package transaction;

public class Transaction {
    private double amount;
    private String method;
    private String status;

    public Transaction(double amount, String method, String status) {
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public void display() {
        System.out.println("Amount: " + (int)amount);
        System.out.println("Method: " + method);
        System.out.println("Status: " + status);
    }
    public double getAmount() {
    return amount;
}
}