package task2;

import com.fasterxml.jackson.annotation.JsonSetter;

public class StudentV2 {
    //region Поля
    @JsonSetter("name")
    private String name;
    @JsonSetter("age")
    private int age;
    @JsonSetter("GPA")
    private transient double GPA;

    //endregion
    //region Конструкторы
    public StudentV2() {
    }

    @Override
    public String toString() {
        return String.format("Имя - %s\nВозраст - %s\nСредний балл - %s", getName(), getAge(), getGPA());
    }

//    public StudentV2(String name, int age, double GPA) {
//        this.name = name;
//        this.age = age;
//        this.GPA = GPA;
//    }//endregion
     //    region Getter Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    //endregion
}
