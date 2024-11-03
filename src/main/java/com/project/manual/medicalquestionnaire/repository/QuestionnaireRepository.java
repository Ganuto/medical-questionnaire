package com.project.manual.medicalquestionnaire.repository;

import com.project.manual.medicalquestionnaire.domain.Questionnaire;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String> {}
