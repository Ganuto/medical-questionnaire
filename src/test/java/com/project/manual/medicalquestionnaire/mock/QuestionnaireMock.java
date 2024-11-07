package com.project.manual.medicalquestionnaire.mock;

import com.project.manual.medicalquestionnaire.controller.data.request.QuestionnaireRecommendationRequest;
import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.domain.Answer;
import com.project.manual.medicalquestionnaire.domain.Choice;
import com.project.manual.medicalquestionnaire.domain.Question;
import com.project.manual.medicalquestionnaire.domain.Questionnaire;
import java.time.LocalDateTime;
import java.util.List;

public abstract class QuestionnaireMock {
  public static Questionnaire createQuestionnaireMock() {
    Questionnaire questionnaire = new Questionnaire();
    questionnaire.setId("6729565399d62821fd94b245");
    questionnaire.setEnabled(true);
    questionnaire.setTitle("Erectile Dysfunction Questionnaire");
    questionnaire.setQuestions(List.of(createQuestionMock()));
    questionnaire.setCreatedAt(LocalDateTime.of(2024, 8, 19, 0, 0));
    return questionnaire;
  }

  public static QuestionnaireResponse createQuestionnaireResponseMock() {
    QuestionnaireResponse questionnaireResponse = new QuestionnaireResponse();
    questionnaireResponse.setId("6729565399d62821fd94b245");
    questionnaireResponse.setEnabled(true);
    questionnaireResponse.setTitle("Erectile Dysfunction Questionnaire");
    questionnaireResponse.setQuestions(List.of(createQuestionMock()));
    questionnaireResponse.setCreatedAt(LocalDateTime.of(2024, 8, 19, 0, 0));
    return questionnaireResponse;
  }

  public static QuestionnaireRecommendationRequest createQuestionnaireRecommendationRequestMock() {
    QuestionnaireRecommendationRequest questionnaireRecommendationRequest =
        new QuestionnaireRecommendationRequest();
    Answer answerMock1 = createAnswerMock("1", "1");
    Answer answerMock2 = createAnswerMock("2", "4");
    Answer answerMock3 = createAnswerMock("3", "2");
    Answer answerMock4 = createAnswerMock("4", "5");
    Answer answerMock5 = createAnswerMock("5", "5");
    questionnaireRecommendationRequest.setUserId(1337L);
    questionnaireRecommendationRequest.setQuestionnaireId("6729565399d62821fd94b245");
    questionnaireRecommendationRequest.setAnswers(List.of(answerMock1));
    return questionnaireRecommendationRequest;
  }

  public static Answer createAnswerMock(String questionId, String choiceId) {
    Answer answer = new Answer();
    answer.setQuestionId(questionId);
    answer.setChoiceId(choiceId);
    answer.setSubQuestionChoiceId(null);
    return answer;
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
