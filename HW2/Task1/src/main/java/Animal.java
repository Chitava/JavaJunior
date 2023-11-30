public abstract class Animal {
    String name;
    double age;

    public Animal(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound(){};





    @Override
    public String toString() {
        return String.format("Питомец %s\nКличка - %s\nВозраст - %s\n", this.getClass(), name, age);
    }


}
