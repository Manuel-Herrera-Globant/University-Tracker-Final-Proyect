package com.university.tracker;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<UniversityClass> classes = new ArrayList<>();

    public static void main(String[] args) {
        initData();
        System.out.println("University Tracker - Data initialized successfully!");
        // TODO: Implement menu
    }

    private static void initData() {
        // Initialize 2 Full-Time Teachers
        teachers.add(new FullTimeTeacher("Pepito Gomez", 3000.0, 5));
        teachers.add(new FullTimeTeacher("Emiliano Perez", 3500.0, 8));

        // Initialize 2 Part-Time Teachers
        teachers.add(new PartTimeTeacher("Alvaro Gonzales", 20.0, 20));
        teachers.add(new PartTimeTeacher("Juan Brown", 25.0, 15));

        // Initialize 6 Students
        students.add(new Student("Anna Garcia", 20));
        students.add(new Student("Carlos Lopez", 21));
        students.add(new Student("Maria Rodriguez", 19));
        students.add(new Student("Juan Martinez", 22));
        students.add(new Student("Laura Sanchez", 20));
        students.add(new Student("Pedro Fernandez", 23));

        // Initialize 4 Classes
        UniversityClass mathClass = new UniversityClass("Algebra", "Edificio A", teachers.get(0)); // FullTime
        mathClass.addStudent(students.get(0));
        mathClass.addStudent(students.get(1));
        mathClass.addStudent(students.get(2));
        classes.add(mathClass);

        UniversityClass physicsClass = new UniversityClass("Fisica", "Edificio B", teachers.get(1)); // FullTime
        physicsClass.addStudent(students.get(3));
        physicsClass.addStudent(students.get(4));
        classes.add(physicsClass);

        UniversityClass englishClass = new UniversityClass("Ingles", "Edificio C", teachers.get(2)); // PartTime
        englishClass.addStudent(students.get(0));
        englishClass.addStudent(students.get(3));
        englishClass.addStudent(students.get(5));
        classes.add(englishClass);

        UniversityClass historyClass = new UniversityClass("Sociales", "Edificio D", teachers.get(3)); // PartTime
        historyClass.addStudent(students.get(1));
        historyClass.addStudent(students.get(2));
        historyClass.addStudent(students.get(4));
        classes.add(historyClass);
    }

}