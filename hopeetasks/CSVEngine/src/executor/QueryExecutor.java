package executor;
import java.util.*;
import model.Row;

public class QueryExecutor {

    public void run(List<Row> data,
                    String column,
                    String condCol,
                    String op,
                    int value) {

        boolean found = false;

        for (Row row : data) {
            String cell = row.get(condCol.trim());

            if (cell == null) {
                System.out.println("Column not found: " + condCol);
                return;
            }

            int num = Integer.parseInt(cell.trim());

            if (op.equals("=") && num == value) {
                System.out.println(row.get(column));
                found = true;
            }
            else if (op.equals(">") && num > value) {
                System.out.println(row.get(column));
                found = true;
            }
            else if (op.equals("<") && num < value) {
                System.out.println(row.get(column));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No data found");
        }
    }
}