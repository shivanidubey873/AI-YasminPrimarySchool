package com.tw.AIYasmin;

public class Student {
    private final int id;
    private String name;
    private String grade;
    private static int idGenerator;
    Student(String name,String grade){
        idGenerator+=1;
        this.name=name;
        this.grade=grade;
        this.id=idGenerator;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
