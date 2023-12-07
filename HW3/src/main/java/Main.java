import task1.Student;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Иван", 23, 4.3);
        System.out.println("До серриализации");
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл: " + student.getGPA());
        student.writeExternal();
        student.readExternal();
        System.out.println("После серриализации");
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл: " + student.getGPA());
        
    }
}