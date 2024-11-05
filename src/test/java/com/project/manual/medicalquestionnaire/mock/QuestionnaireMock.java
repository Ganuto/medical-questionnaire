package com.project.manual.medicalquestionnaire.mock;

import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.domain.Choice;
import com.project.manual.medicalquestionnaire.domain.Question;
import java.time.LocalDateTime;
import java.util.List;

public abstract class QuestionnaireMock {
  public static QuestionnaireResponse createQuestionnaireResponseMock() {
    QuestionnaireResponse questionnaireResponse = new QuestionnaireResponse();
    questionnaireResponse.setId("6729565399d62821fd94b245");
    questionnaireResponse.setEnabled(true);
    questionnaireResponse.setTitle("Erectile Dysfunction Questionnaire");
    questionnaireResponse.setQuestions(List.of(createQuestionMock()));
    questionnaireResponse.setCreatedAt(LocalDateTime.of(2024, 8, 19, 0, 0));
    return questionnaireResponse;
  }

  private static Question createQuestionMock() {
    Question question = new Question();
    question.setId("7029565399d62832fd94b645");
    question.setEnabled(true);
    question.setTitle("1. Do you have difficulty getting or maintaining an erection?");
    question.setOrder(1);
    question.setChoices(List.of(createChoiceMock()));
    return question;
  }

  private static Choice createChoiceMock() {
    Choice choice = new Choice();
    choice.setId("8029565399d62832fd94b645");
    choice.setValue("Yes");
    choice.setNextQuestionId("2");
    choice.setSubQuestionId(null);
    return choice;
  }
}
