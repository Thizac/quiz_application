package com.wieczerzak.quiz_application.services;

import com.wieczerzak.quiz_application.dao.entities.Quiz;
import com.wieczerzak.quiz_application.dao.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizService {

    private QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }


    public Optional<Quiz> findById(Long id){
        return quizRepository.findById(id);
    }

    public Iterable<Quiz>findAll(){
        return quizRepository.findAll();
    }

    public Quiz save(Quiz quizQuestion){
        return quizRepository.save(quizQuestion);
    }

    public void deleteById(Long id){
        quizRepository.deleteById(id);
    }
}
