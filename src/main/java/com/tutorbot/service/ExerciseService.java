
package com.tutorbot.service;

import com.tutorbot.model.Exercise;
import com.tutorbot.model.Feedback;
import com.tutorbot.repository.ExerciseRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public List<Exercise> getExerciseByDifficulty(String difficulty) {
        return exerciseRepository.findAll().stream()
                .filter(exercise -> exercise.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }

    public Feedback submitAnsert(int studentId, int exerciseId, String answer) {
        Exercise exercise = exerciseRepository.findAll().stream()
                .filter(ex -> ex.getId() == exerciseId)
                .findFirst()
                .orElse(null);

        if (exercise == null) {
            return new Feedback(studentId, exerciseId, answer, 0, "Exercise not found", false);
        }

        // Simulate scoring logic
        int score = answer.equalsIgnoreCase("correct answer") ? 100 : 40;
        String message = score > 40 ? "Correct!" : "Incorrect. Try again, you can do it!";
        boolean correct = score > 40;

        return new Feedback(studentId, exerciseId, answer, score, message, correct);
    }
}
