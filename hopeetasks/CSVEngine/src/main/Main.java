package main;
import java.util.*;
import reader.CSVReader;
import executor.QueryExecutor;
import model.Row;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("File path: ");
        String path = sc.nextLine();

        System.out.print("Enter column to display: ");
        String column = sc.nextLine().trim();

        System.out.print("Condition column: ");
        String condCol = sc.nextLine().trim();

        System.out.print("Operator (> or <): ");
        String op = sc.nextLine().trim();

        System.out.print("Value: ");
        int value = sc.nextInt();

        CSVReader reader = new CSVReader();
        List<Row> data = reader.read(path);

        QueryExecutor ex = new QueryExecutor();
        ex.run(data, column, condCol, op, value);
    }
}