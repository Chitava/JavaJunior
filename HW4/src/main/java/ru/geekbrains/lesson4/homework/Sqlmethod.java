package ru.geekbrains.lesson4.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.lesson4.models.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sqlmethod {
    private static void createDB() throws SQLException {
        String url = "jdbc:mysql://students.db:3306/";
        String user = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS courses;";
            try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
                statement.execute();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}

        public static SessionFactory getSession () {

            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Course.class)
                    .buildSessionFactory();

        }

        public static void insertToDB (Course course) throws SQLException {
            createDB();
            try (Session session = getSession().openSession()) {
                session.beginTransaction();
                session.save(course);
                System.out.printf("Курс %s добавлен в базу", course.getName());
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static Course selectFromDBbyId ( int id){
            try (Session session = getSession().openSession()) {
                session.beginTransaction();
                Course course = session.get(Course.class, id);
                return course;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void updateDataDB(Course course){
            try (Session session = getSession().openSession()) {
                session.beginTransaction();
                session.update(course);
                System.out.printf("Курс %s обновлен", course.getName());
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void deleteDataDB(Course course){
        try (Session session = getSession().openSession()) {
            session.beginTransaction();
            session.delete(course);
            System.out.printf("Курс %s удален", course.getName());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }
