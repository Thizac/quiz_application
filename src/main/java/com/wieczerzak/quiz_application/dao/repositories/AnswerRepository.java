package com.wieczerzak.quiz_application.dao.repositories;

import com.wieczerzak.quiz_application.dao.entities.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long> {
}
