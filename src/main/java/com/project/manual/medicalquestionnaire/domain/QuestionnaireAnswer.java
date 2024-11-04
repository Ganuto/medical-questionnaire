package com.project.manual.medicalquestionnaire.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "questionnaire_answer")
public class QuestionnaireAnswer {
    private String questionnaireId;
    private List<QuestionnaireAnswerQuestion> questions;
}
