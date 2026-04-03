package com.expense.main;

import com.expense.service.ExpenseService;

import java.util.Locale.Category;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseService service = new ExpenseService();

        int choice;

        do {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Total Expense");
            System.out.println("5. Set Budget");
            System.out.println("6. Category Analysis");
            System.out.println("7. Exit");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    sc.nextLine(); // consume newline

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    service.addExpense(id, amount, category);
                    break;

                case 2:
                    service.viewExpenses();
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    service.deleteExpense(deleteId);
                    break;

                case 4:
                    service.totalExpense();
                    break;
                case 5:
                    System.out.print("Enter Budget: ");
                    double budget = sc.nextDouble();
                    service.setBudget(budget);
                    break;
                case 6:
                    service.categoryAnalysis();
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    break;
                 default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}