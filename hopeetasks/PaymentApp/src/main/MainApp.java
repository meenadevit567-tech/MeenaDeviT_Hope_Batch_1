package main;
import utils.Validation; 
import payment.*;
import processor.PaymentProcessor;
import transaction.Transaction;
import utils.Validation;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PaymentProcessor processor = new PaymentProcessor();

        ArrayList<Transaction> history = new ArrayList<>();

        while (true) {

            System.out.println("1. Pay");
            System.out.println("2. View History");
            System.out.println("3. Analytics");
            System.out.println("4. Exit");
            int option = sc.nextInt();

            if (option == 1) {

                System.out.println("Choose Payment Method:");
                System.out.println("1. Card  2. UPI  3. Wallet");

                int choice = sc.nextInt();

                System.out.println("Enter amount:");
                double amount = sc.nextDouble();

                PaymentMethod method;
                String methodName;

                if (choice == 1) {
                    method = new CardPayment();
                    methodName = "Card";
                } else if (choice == 2) {
                    method = new UPIPayment();
                    methodName = "UPI";
                } else {
                    method = new WalletPayment();
                    methodName = "Wallet";
                }

                if (!Validation.isValidAmount(amount)) {
                System.out.println("Invalid Amount");
                continue;
            }

            if (amount > 100000) {
                System.out.println("Payment Failed(Limit exceeded)");
                history.add(new Transaction(amount, methodName, "Failed"));
            } else {
           Random rand = new Random();
int otp = 1000 + rand.nextInt(9000);

System.out.println("Generated OTP: " + otp);

int attempts = 0;

while (attempts < 3) {
    System.out.print("Enter OTP: ");
    int userOtp = sc.nextInt();

    if (userOtp == otp) {
        break;
    } else {
        attempts++;
        System.out.println("Wrong OTP!! Attempts left: " + (3 - attempts));
    }
}

if (attempts == 3) {
    System.out.println("Account Blocked due to Suspicious Activity");
    history.add(new Transaction(amount, methodName, "Blocked"));
    continue;
}
            }

        
            processor.process(method, amount);
            history.add(new Transaction(amount, methodName, "Success"));
            }

             else if (option == 2) {

                System.out.println("\nTransaction History:");
                for (Transaction t : history) {
                    t.display();
                }

            }
            else if (option == 3) {

                double total = 0;

                for (Transaction t : history) {
                    total += t.getAmount();
                }

                int count = history.size();
                double average = (count == 0) ? 0 : total / count;

                System.out.println("\n---Spending Insights---");
                System.out.println("Total Transactions: " + count);
                System.out.println("Total Spent: Rs." + (int)total);
                System.out.println("Average Spend: Rs." + (int)average);

                if (total > 5000) {
                    System.out.println("Budget Exceeded!");
                } else {
                    System.out.println("Within Budget");
                }
            }
             else if (option == 4) {
                System.out.println("Exiting");
                break;
            }
        }
    }
}
