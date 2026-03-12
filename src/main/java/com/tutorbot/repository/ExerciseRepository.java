package com.tutorbot.repository;

import com.tutorbot.model.Exercise;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ExerciseRepository {
    private List<Exercise> exercises = new ArrayList<>();

    public ExerciseRepository() {
        exercises.add(new Exercise(1, "Spring Boot", "What annotation marks a REST controller?", "easy"));
        exercises.add(new Exercise(2, "Spring boot", "What annotation is used to inject dependencies?", "easy"));
        exercises.add(new Exercise(3, "Java", "Which keyboard creates a subclass?", "medium"));
        exercises.add(new Exercise(4, "Spring", "Which annotation maps HTTP GET requests?", "medium"));
    }

    public List<Exercise> findAll() {
        return exercises;
    }
}