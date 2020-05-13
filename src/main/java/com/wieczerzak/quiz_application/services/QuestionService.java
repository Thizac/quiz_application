package com.wieczerzak.quiz_application.services;

import com.wieczerzak.quiz_application.dao.entities.QuizQuestion;
import com.wieczerzak.quiz_application.dao.repositories.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j(topic = "app.logger")
public class QuestionService {

    public QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public Optional<QuizQuestion> findById(Long id){
        if(questionRepository.existsById(id)){
            log.debug("Returning data from question repository");
            return questionRepository.findById(id);
        }
        return Optional.empty();
    }

    public Iterable<QuizQuestion>findAll(){
        log.debug("Returning data from question repository");
        return questionRepository.findAll();
    }

    public QuizQuestion save(QuizQuestion quizQuestion){
        log.debug("Saving question in repository");
        return questionRepository.save(quizQuestion);
    }

    public void deleteById(Long id){
        if (questionRepository.existsById(id)) {
            log.debug("Deleting question from repository");
            questionRepository.deleteById(id);
        }
    }


}
