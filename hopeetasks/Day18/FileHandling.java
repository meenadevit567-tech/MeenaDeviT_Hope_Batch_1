package Day18;
import java.io.*;
public class FileHandling {
    public static void main(String[] args) {
        try{
            File file=new File("hope_batch.txt");
            if(file.createNewFile()){
                System.out.println("File Created:"+file.getName());
            }else{
                System.out.println("File Already Exists");
            }
        }catch(Exception e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
    
}