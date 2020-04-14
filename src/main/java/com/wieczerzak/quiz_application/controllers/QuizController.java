package com.wieczerzak.quiz_application.controllers;

import com.wieczerzak.quiz_application.dao.entities.Quiz;
import com.wieczerzak.quiz_application.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("quizzes")
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Quiz>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quizService.findAll());
    }

    @GetMapping({"quizId"})
    public ResponseEntity<Quiz> getById(@RequestParam Long quizId) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quizService.findById(quizId).get());

    }

    @PostMapping
    public ResponseEntity<Quiz> addQuestion(@RequestBody Quiz quiz) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(quizService.save(quiz));
    }

    @DeleteMapping({"quizId"})
    public ResponseEntity<String> deleteQuestion(@RequestParam Long quizId){
        quizService.deleteById(quizId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Quiz with ID: "+ quizId+" deleted");
    }

}
