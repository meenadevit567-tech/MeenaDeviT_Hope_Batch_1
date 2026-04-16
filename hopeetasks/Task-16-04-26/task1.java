import java.io.*;
public class task1{
    public static void main(String[] args) {
        try{   
        File file=new File("sample.txt");
        file.createNewFile();
        File newFile=new File("source.txt");
        if(file.renameTo(newFile)){
            System.out.println("File renamed successfully");
        }
        else{
            System.out.println("Failed to rename the file");
        }
    }
    catch(Exception e){
        System.out.println(e);
    }
    }
}
