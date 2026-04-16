package Day18;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
public class Serialization {
    public static void main(String[] args) {
        Student s1 = new Student(1, "John");
        try {
            FileOutputStream fos = new FileOutputStream("student.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.close();
            fos.close();
            System.out.println("Object serialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}