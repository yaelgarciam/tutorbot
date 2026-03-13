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

    /**
     * Registra un nuevo estudiante y lo devuelve. Por ahora el id viene en el cuerpo.
     */
    public Student registerStudent(Student student) {
        studentRepository.save(student);
        return student;
    }
}
