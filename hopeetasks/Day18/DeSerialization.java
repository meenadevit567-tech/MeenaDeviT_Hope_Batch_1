package Day18;
import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
}

public class DeSerialization {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("student.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Student s1 = (Student) ois.readObject();

        ois.close();
        fis.close();

        System.out.println("ID: " + s1.id);
        System.out.println("Name: " + s1.name);
    }
}