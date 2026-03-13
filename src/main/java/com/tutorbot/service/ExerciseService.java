
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

    public Feedback submitAnswer(int studentId, int exerciseId, String answer) {
        Exercise exercise = exerciseRepository.findById(exerciseId);

        if (exercise == null) {
            return new Feedback(studentId, exerciseId, answer, 0, "Exercise not found", false);
        }

        String expected = exercise.getAnswer() == null ? "" : exercise.getAnswer().trim();
        String provided = answer == null ? "" : answer.trim();
        boolean correct = !expected.isEmpty() && expected.equalsIgnoreCase(provided);
        int score = correct ? 100 : 40;
        String message = correct ? "Correct!" : "Incorrect. Expected: " + expected;

        return new Feedback(studentId, exerciseId, answer, score, message, correct);
    }
}
