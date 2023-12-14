package ru.geekbrains.lesson4.homework;

import ru.geekbrains.lesson4.models.Course;

public class Program {

    /**
     * Задание
     * =======
     * Создайте базу данных (например, SchoolDB).
     * В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
     * Настройте Hibernate для работы с вашей базой данных.
     * Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
     * Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
     * Убедитесь, что каждая операция выполняется в отдельной транзакции.
     */
    public static void main(String[] args) {
//        Course course = new Course(1,"Java основы", 8);
//        Sqlmethod.insertToDB(course);
        Course course1 = Sqlmethod.selectFromDBbyId(6);
        System.out.println(course1);
    }
}
