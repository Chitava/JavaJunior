public class Dog extends Animal{
    public Dog(String name, double age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Собака сказала - гав");
    }
}
