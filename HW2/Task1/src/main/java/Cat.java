public class Cat extends Animal{
    public Cat(String name, double age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("мяяу");;
    }
}
