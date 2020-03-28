package com.wieczerzak.quiz_application.dao;

import com.wieczerzak.quiz_application.dao.entities.QuizQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuizQuestion, Long> {
}
