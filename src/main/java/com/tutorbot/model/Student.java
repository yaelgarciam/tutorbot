package com.tutorbot.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String level;
    private int age;

    public Student() {}

    public Student(int id, String name, String email, String level, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.level = level;
        this.age = age;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }   

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

 }
