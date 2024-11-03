package com.project.manual.medicalquestionnaire.mapper;

import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.domain.Questionnaire;
import java.util.List;

public abstract class QuestionnaireMapper {
  public static QuestionnaireResponse toResponse(Questionnaire questionnaire) {
    QuestionnaireResponse questionnaireResponse = new QuestionnaireResponse();

    questionnaireResponse.setQuestionnaireId(questionnaire.getQuestionnaireId());
    questionnaireResponse.setTitle(questionnaireResponse.getTitle());
    questionnaireResponse.setQuestions(questionnaire.getQuestions());
    questionnaireResponse.setCreatedAt(questionnaire.getCreatedAt());

    return questionnaireResponse;
  }

  public static List<QuestionnaireResponse> toResponseList(List<Questionnaire> questionnaireList) {
    return questionnaireList.stream().map(QuestionnaireMapper::toResponse).toList();
  }
}