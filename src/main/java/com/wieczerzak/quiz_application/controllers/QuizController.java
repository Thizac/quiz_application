package com.wieczerzak.quiz_application.controllers;

import com.wieczerzak.quiz_application.dao.entities.Quiz;
import com.wieczerzak.quiz_application.exceptions.NotFoundException;
import com.wieczerzak.quiz_application.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("quizzes")
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService){ //throws ...
        this.quizService = quizService;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Quiz>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quizService.findAll());
    }

    @GetMapping({"quizId"})
    public ResponseEntity<Quiz> getById(@RequestParam Long quizId) throws NotFoundException {
        if(!((quizService.findById(quizId)).isPresent()))
            throw new NotFoundException();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quizService.findById(quizId).get());
    }

    @PostMapping
    public ResponseEntity<Quiz> addQuestion(@Valid @RequestBody Quiz quiz, BindingResult bindingResult)
    throws BindException {

        if (bindingResult.hasErrors()) throw new BindException(bindingResult);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(quizService.save(quiz));
    }

    @DeleteMapping({"quizId"})
    public ResponseEntity<String> deleteQuestion(@Valid @RequestParam Long quizId) {
        quizService.deleteById(quizId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Quiz with ID: "+ quizId+" deleted");
    }

}
