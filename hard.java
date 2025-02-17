import java.io.*;

class Student implements Serializable {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

public class SerializationExample {
    public static void serializeStudent(Student student, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(student);
            System.out.println("Student object serialized and saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student deserializeStudent(String fileName) {
        Student student = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            student = (Student) ois.readObject();
            System.out.println("Student object deserialized from " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
        return student;
    }

    public static void main(String[] args) {
        Student student = new Student(1, "John Doe", 3.8);

       
        serializeStudent(student, "student.ser");

       
        Student deserializedStudent = deserializeStudent("student.ser");
        if (deserializedStudent != null) {
            System.out.println("Deserialized Student: " + deserializedStudent);
        }
    }
}
