package reader;
import java.io.*;
import java.util.*;
import model.Row;

public class CSVReader {

    public List<Row> read(String path) {
        List<Row> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            String first = br.readLine();
            String[] headers = first.split(",");

            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                Map<String, String> map = new HashMap<>();

                for (int i = 0; i < headers.length; i++) {
                    map.put(headers[i], values[i]);
                }

                list.add(new Row(map));
            }

        } catch (Exception e) {
            System.out.println("File error");
        }

        return list;
    }
}