package com.tutorbot.service;

import com.tutorbot.model.Student;
import com.tutorbot.repository.StudentRepository;   

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    private int generateId() {
        int random = (int) (Math.random() * 100000); // 0 - 99999
        return 1600000 + random; // garantiza que empieza con 16 y 5 dígitos más
    }

    private String buildEmail(int id) {
        return "A0" + id + "@tec.mx";
    }

    /**
     * Registra un estudiante generando id y correo automáticamente.
     */
    public Student registerStudent(String name, int age, String level) {
        int id = generateId();
        String email = buildEmail(id);
        Student student = new Student(id, name, email, level, age);
        studentRepository.save(student);
        return student;
    }
}
