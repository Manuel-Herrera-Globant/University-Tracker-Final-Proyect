package com.university.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<UniversityClass> classes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<UniversityClass> classes = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();
        showMenu();
    }

    private static void initializeData() {
        // 1. Teachers (Full Time and Part Time)
        teachers.add(new FullTimeTeacher("Alex Restrepo", 3000, 8));
        teachers.add(new FullTimeTeacher("Betty Pinzón", 3500, 12));
        teachers.add(new PartTimeTeacher("Wilson Cano", 50, 20));
        teachers.add(new PartTimeTeacher("Doña Gladys ", 45, 15));

        // 2. Students (Colombian names)
        students.add(new Student("Carlos Quintero", 20));
        students.add(new Student("Luz Beltrán", 21));
        students.add(new Student("Duván Zapata", 19));
        students.add(new Student("Yulitza Córdoba", 22));
        students.add(new Student("Jefferson Cossio", 20));
        students.add(new Student("Marcela Valencia", 21));

        // 3. Classes
        UniversityClass math = new UniversityClass("Calculo Integral", "Salon 402B", teachers.get(0));
        math.addStudent(students.get(0));
        math.addStudent(students.get(1));
        
        UniversityClass physics = new UniversityClass("Fisica Mecanica", "Laboratorio G", teachers.get(1));
        physics.addStudent(students.get(2));
        physics.addStudent(students.get(3));

        UniversityClass business = new UniversityClass("Emprendimiento Paisa", "Salon 105", teachers.get(2));
        business.addStudent(students.get(4));
        business.addStudent(students.get(5));

        UniversityClass arts = new UniversityClass("Historia del Arte", "Auditorio Manuelirta", teachers.get(3));
        arts.addStudent(students.get(0));
        arts.addStudent(students.get(5));

        classes.add(math);
        classes.add(physics);
        classes.add(business);
        classes.add(arts);
    }

    private static void showMenu() {
        int option = 0;
        while (option != 7) {
            System.out.println("\nWelcomeee to the Uni-Tracker menu \n");
            System.out.println("1. Print all professors");
            System.out.println("2. Print all classes & details");
            System.out.println("3. Create a new student and add to a class");
            System.out.println("4. Create a new class");
            System.out.println("5. List classes for a given student ID");
            System.out.println("6. Print students in a class");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");
            
            try {
                option = Integer.parseInt(sc.nextLine());
                executeOption(option);
            } catch (Exception e) {
                System.out.println("Nope...READ PLEASE, Now enter a number.");
            }
        }
    }

    private static void executeOption(int option) {
        switch (option) {
            case 1: {
                printTeachers();
                break;
            }
            case 2: {
                printClassesSubmenu();
                break;
            }
            case 3: {
                createNewStudent();
                break;
            }
            case 4: {
                createNewClass();
                break;
            }
            case 5: {
                searchClassesByStudent();
                break;
            }
            case 6: {
                printStudentsInClass();
                break;
            }
            case 7: {
                System.out.println("Chao");
                break;
            }
            default: {
                System.out.println("Not an option.");
                break;
            }
        }
    }

    private static void printTeachers() {
        System.out.println("\nPROFESSORS LIST\n");
        for (Teacher t : teachers) {
            String type = (t instanceof FullTimeTeacher) ? "Full-Time" : "Part-Time";
            System.out.println("Name: " + t.getName() + " | Type: " + type + " | Salary: " + t.calculateSalary());
        }
    }

    private static void printClassesSubmenu() {
        System.out.println("\nREGISTERED CLASSES\n");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ". " + classes.get(i).getName());
        }
        System.out.print("Select a class index to see details (0 to return): ");
        int choice = Integer.parseInt(sc.nextLine()) - 1;
        
        if (choice >= 0 && choice < classes.size()) {
            UniversityClass c = classes.get(choice);
            System.out.println("\nClass: " + c.getName() + " | Room: " + c.getClassroom());
            System.out.println("Teacher: " + c.getTeacher().getName());
            System.out.println("Students:");
            for (Student s : c.getStudents()) {
                System.out.println(" - " + s.getName() + " (ID: " + s.getId() + ")");
            }
        }
    }

    private static void createNewStudent() {
        System.out.print("Enter full name: "); String name = sc.nextLine();
        System.out.print("Enter age: "); int age = Integer.parseInt(sc.nextLine());
        Student newStudent = new Student(name, age);
        students.add(newStudent);

        System.out.println("Select a class index to enroll the student:");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println(i + ". " + classes.get(i).getName());
        }
        int classIdx = Integer.parseInt(sc.nextLine());
        classes.get(classIdx).addStudent(newStudent);
        System.out.println("Student created and enrolled successfully.");
    }

    private static void createNewClass() {
        System.out.print("Class Name: "); String name = sc.nextLine();
        System.out.print("Classroom: "); String room = sc.nextLine();
        
        System.out.println("Select a teacher index:");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println(i + ". " + teachers.get(i).getName());
        }
        int tIdx = Integer.parseInt(sc.nextLine());
        
        UniversityClass newClass = new UniversityClass(name, room, teachers.get(tIdx));
        
        System.out.println("Enter student IDs to add (comma separated, e.g: 1,2,5):");
        String[] ids = sc.nextLine().split(",");
        for (String idStr : ids) {
            int targetId = Integer.parseInt(idStr.trim());
            for (Student s : students) {
                if (s.getId() == targetId) {
                    newClass.addStudent(s);
                }
            }
        }
        classes.add(newClass);
        System.out.println("New class added to the system.");
    }

    private static void printStudentsInClass() {
        System.out.println("\nSELECT A CLASS TO SEE ITS STUDENTS\n");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println(i + ". " + classes.get(i).getName());
        }
        
        System.out.print("Enter class index: ");
        try {
            int classIdx = Integer.parseInt(sc.nextLine());
            if (classIdx >= 0 && classIdx < classes.size()) {
                UniversityClass selectedClass = classes.get(classIdx);
                System.out.println("\nStudents in " + selectedClass.getName() + ":");
                
                if (selectedClass.getStudents().isEmpty()) {
                    System.out.println("This class has no students enrolled yet.");
                } else {
                    for (Student s : selectedClass.getStudents()) {
                        System.out.println(" - " + s.getName() + " (ID: " + s.getId() + ")");
                    }
                }
            } else {
                System.out.println("Invalid class index.");
            }
        } catch (Exception e) {
            System.out.println("Error: Please enter a valid number.");
        }
    }

    private static void searchClassesByStudent() {
        System.out.print("Enter Student ID: ");
        int searchId = Integer.parseInt(sc.nextLine());
        System.out.println("The student is enrolled in:");
        boolean found = false;
        for (UniversityClass c : classes) {
            for (Student s : c.getStudents()) {
                if (s.getId() == searchId) {
                    System.out.println(" -> " + c.getName());
                    found = true;
                }
            }
        }
        if (!found) System.out.println("No classes found for this ID.");
    }
}