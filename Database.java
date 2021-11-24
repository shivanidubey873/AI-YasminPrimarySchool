package com.tw.AIYasmin;

import java.util.ArrayList;
import java.util.Scanner;

class Database {
    private static ArrayList<Student> students = new ArrayList<>();
    private final String userRole;

    public Database(String userRole) {
        this.userRole = userRole;
    }

    public void addStudentsData(Student o) {
        if (userRole.equalsIgnoreCase("admin")) {
            students.add(o);
        } else {
            System.out.println("You are not authorized to add new data to database");
        }
    }

    public void removeStudentsData(int id) {
        if (userRole.equalsIgnoreCase("admin")) {
            for(Student iterator: students){
                if(iterator.getId()==id){
                    students.remove(iterator);
                    break;
                }
            }

        } else {
            System.out.println("You are not authorized to remove any data from database");
        }
    }

    public void updateStudentsData(int id, Student newData) {
        if (userRole.equalsIgnoreCase("admin")) {
            for(Student iterator: students){
                if(iterator.getId()==id){
                    iterator.setName(newData.getName());
                    iterator.setGrade(newData.getGrade());
                    break;
                }
            }
        } else {
            System.out.println("You are not authorized to update any data in database");
        }
    }

    public void view() {
        for (Student iterator : students) {
            System.out.println(iterator.getId()+" "+iterator.getName()+" "+iterator.getGrade());
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Database admin = new Database("admin"), nonTeachingUser = new Database("non-teaching");
        String name,grade;
        for(int iterator=0;iterator<3;iterator++){
            name=scan.nextLine();
            grade=scan.nextLine();
            Student o=new Student(name,grade);
            admin.addStudentsData(o);
            nonTeachingUser.addStudentsData(o);
        }
        admin.view();
        System.out.println("Enter id of student whose record you want to delete");
        int id= scan.nextInt();
        admin.removeStudentsData(id);
        admin.view();
        System.out.println("Enter id of student whose record you want to update");
        id=scan.nextInt();

        scan.nextLine(); //reads end of line after reading int so that I can read name and grade properly
        System.out.println("Enter new data");
        name= scan.nextLine();
        grade= scan.nextLine();
        Student newData= new Student(name,grade);
        admin.updateStudentsData(id,newData);
        nonTeachingUser.view();
    }
}
