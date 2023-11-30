import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**Задача 1:
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте. Вызовите метод "makeSound()" у каждого объекта, если такой
 метод присутствует.
 */


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Animal> nursery = new ArrayList<>();
        Dog dog1 = new Dog("Бобик", 2.5);
        Dog dog2 = new Dog("Шарик", 2.0);
        Dog dog3 = new Dog("Жучка", 1.5);
        Cat cat1 = new Cat("Мурка", 1);
        Cat cat2 = new Cat("Васька", 3);
        Cat cat3 = new Cat("Дашка", 5);
        nursery.add(dog1);
        nursery.add(dog2);
        nursery.add(dog3);
        nursery.add(cat1);
        nursery.add(cat2);
        nursery.add(cat3);
        for (Animal animal: nursery) {
            Class <?> person = animal.getClass();
            System.out.println("Имя класса: " + person);
            System.out.println("Поля класса: " + Arrays.toString(person.getSuperclass().getDeclaredFields()));
            System.out.println("Родительский класс: " + person.getSuperclass());
            System.out.println("Методы класса: " +  Arrays.toString(person.getDeclaredMethods()));
            System.out.println("Конструкторы класса: " + Arrays.toString(person.getConstructors()));
            Method method = person.getSuperclass().getDeclaredMethod("makeSound");
            method.setAccessible(true);
            method.invoke(animal);
        }


    }
}