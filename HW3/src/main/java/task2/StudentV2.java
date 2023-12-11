package task2;

import com.fasterxml.jackson.annotation.JsonSetter;

public class StudentV2 {
    //region Поля


    private String age;


    //endregion
    //region Конструкторы
    public StudentV2() {
    }

    @Override
    public String toString() {
        return String.format("Возраст - %s\n", getAge());
    }

//    public StudentV2(String name, int age, double GPA) {
//        this.name = name;
//        this.age = age;
//        this.GPA = GPA;
//    }//endregion
     //    region Getter Setter




    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    //endregion
}
