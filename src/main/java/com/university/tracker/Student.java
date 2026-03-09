package com.university.tracker;

public class Student {

    private String name;

    private int id;

    private int age;

    private static int idCounter = 1;

    public Student(String name, int age) {

        this.name = name;

        this.age = age;

        this.id = idCounter++;

    }

    public String getName() {

        return name;

    }

    public int getId() {

        return id;

    }

    public int getAge() {

        return age;

    }

}