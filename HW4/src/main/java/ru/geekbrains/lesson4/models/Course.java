package ru.geekbrains.lesson4.models;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    //region поля
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;
    //endregion

    //region конструкторы
    public Course() {
    }

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(int duration, String title) {
        this.title = title;
        this.duration = duration;
    }

    //endregion



    //region getters setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format("Курс %s:\nПродолжительность - %s", getName(), getDuration());
    }
    //endregion
}
