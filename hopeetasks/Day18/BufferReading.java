package Day18;
import java.io.*;
public class BufferReading {
    public static void main(String[] args) {
       try{ 
        BufferedReader reader= new BufferedReader(new FileReader("sample.txt"));
        while(reader.ready()){
            System.out.println(reader.readLine());
        }
        reader.close();
    }
    catch(Exception e){
        System.out.println(e);
    }
    }
}