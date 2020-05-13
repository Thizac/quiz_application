package com.wieczerzak.quiz_application.services;

import com.wieczerzak.quiz_application.dao.entities.Quiz;
import com.wieczerzak.quiz_application.dao.repositories.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j(topic = "app.logger")
public class QuizService {

    private QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }


    public Optional<Quiz> findById(Long id){
        if(quizRepository.existsById(id)){
            log.debug("Returning data from quiz repository");
            return quizRepository.findById(id);
        }
        return Optional.empty();
    }

    public Iterable<Quiz>findAll(){
        log.debug("Returning data from quiz repository");
        return quizRepository.findAll();
    }

    public Quiz save(Quiz quizQuestion){
        log.debug("Saving quiz in repository");
        return quizRepository.save(quizQuestion);
    }

    public void deleteById(Long id){
        if (quizRepository.existsById(id)) {
            log.debug("Deleting quiz from repository");
            quizRepository.deleteById(id);
        }
    }
}
