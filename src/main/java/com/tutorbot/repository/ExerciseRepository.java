package com.tutorbot.repository;

import com.tutorbot.model.Exercise;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ExerciseRepository {
    private List<Exercise> exercises = new ArrayList<>();

    public ExerciseRepository() {
        exercises.add(new Exercise(1, "Spring Boot", "What annotation marks a REST controller?", "easy", "@RestController"));
        exercises.add(new Exercise(2, "Spring Boot", "What annotation is used to inject dependencies?", "easy", "@Autowired"));
        exercises.add(new Exercise(3, "Java", "Which keyword creates a subclass?", "medium", "extends"));
        exercises.add(new Exercise(4, "Spring", "Which annotation maps HTTP GET requests?", "medium", "@GetMapping"));
    }

    public List<Exercise> findAll() {
        return exercises;
    }

    public Exercise findById(int id) {
        return exercises.stream()
                .filter(ex -> ex.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
