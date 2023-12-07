package task1;

import java.io.*;

public class Student implements Serializable {
    //region Поля
    private String name;
    private int age;
    private transient double GPA;

    //endregion
    //region Конструкторы
    public Student() {

    }

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }//endregion

    //region method

    public void writeExternal() throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream("userdata.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(this);
            System.out.println("Объект Student сериализован.");
        }
    }


    public void readExternal() throws IOException, ClassNotFoundException {
        try(FileInputStream fileInputStream = new FileInputStream("userdata.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            Student temp = (Student) objectInputStream.readObject();
            setName(temp.getName());
            setAge(temp.getAge());
            setGPA(temp.getGPA());
            System.out.println("Объект Student десериализован.");
        }
    }
    //endregion

    //region Getter Setter
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
