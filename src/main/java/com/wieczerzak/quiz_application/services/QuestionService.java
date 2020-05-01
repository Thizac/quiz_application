package com.wieczerzak.quiz_application.services;

import com.wieczerzak.quiz_application.dao.entities.QuizQuestion;
import com.wieczerzak.quiz_application.dao.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    public QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public Optional<QuizQuestion> findById(Long id){
        if(questionRepository.existsById(id)){
            return questionRepository.findById(id);
        }
        return Optional.empty();
    }

    public Iterable<QuizQuestion>findAll(){
        return questionRepository.findAll();
    }

    public QuizQuestion save(QuizQuestion quizQuestion){
        return questionRepository.save(quizQuestion);
    }

    public void deleteById(Long id){
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
        }
    }


}
