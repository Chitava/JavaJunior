import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import task1.Student;
import task2.SerilaiseJSON;
import task2.StudentV2;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Student student = new Student("Иван", 23, 4.3);
//        System.out.println("До серриализации");
//        System.out.println("Имя: " + student.getName());
//        System.out.println("Возраст: " + student.getAge());
//        System.out.println("Средний балл: " + student.getGPA());
//        student.writeExternal();
//        student.readExternal();
//        System.out.println("После серриализации");
//        System.out.println("Имя: " + student.getName());
//        System.out.println("Возраст: " + student.getAge());
//        System.out.println("Средний балл: " + student.getGPA());

//        StudentV2 student = new StudentV2("Вася", 25, 4.2);
//        SerilaiseJSON.serilaise(student, "userdata.json");
        StudentV2 st = SerilaiseJSON.deserilaise("userdata.json");
        System.out.println(st);
    }
}