package com.tutorbot.repository;

import com.tutorbot.model.Student;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.*;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        students.add(new Student(1644973, "Jose Emilio Inzunza Garcia", "A01644973@tec.mx", "beginner", 20));
        students.add(new Student(1352461, "Yael Garcia Morelos", "A01352461@tec.mx", "intermediate", 21));
        students.add(new Student(1642057, "Patricio Blanco Rafols", "A01642057@tec.mx", "advanced", 22));
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Student student) { students.add(student); }
}
