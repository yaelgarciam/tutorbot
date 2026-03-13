package com.tutorbot.controller;

import com.tutorbot.model.Exercise;
import com.tutorbot.model.Feedback;
import com.tutorbot.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService service;

    @GetMapping
    public List<Exercise> getExercises(@RequestParam(required = false) String difficulty){

        if(difficulty != null){
            return service.getExerciseByDifficulty(difficulty);
        }

        return service.getAllExercises();
    }

    @PostMapping("/submit")
    public Feedback submitAnswer(@RequestBody Map<String, Object> body){

        int studentId = (int) body.get("studentId");
        int exerciseId = (int) body.get("exerciseId");
        String answer = (String) body.get("answer");

        return service.submitAnswer(studentId, exerciseId, answer);
    }

}
