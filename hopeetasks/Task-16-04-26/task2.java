import java.io.*;
import java.nio.file.*;
public class task2 {
    public static void main(String[] args) {
        try{
            Files.copy(Paths.get("source.txt"),Paths.get("destination.txt") );
            System.out.println("Contents Copied successfully");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}