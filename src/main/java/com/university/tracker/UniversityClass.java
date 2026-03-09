package com.university.tracker;

import java.util.List;

import java.util.ArrayList;

public class UniversityClass {

    private String name;

    private String classroom;

    private List<Student> students;

    private Teacher teacher;

    public UniversityClass(String name, String classroom, Teacher teacher) {

        this.name = name;

        this.classroom = classroom;

        this.teacher = teacher;

        this.students = new ArrayList<>();

    }

    public String getName() {

        return name;

    }

    public String getClassroom() {

        return classroom;

    }

    public List<Student> getStudents() {

        return students;

    }

    public Teacher getTeacher() {

        return teacher;

    }

    public void addStudent(Student student) {

        students.add(student);

    }

}