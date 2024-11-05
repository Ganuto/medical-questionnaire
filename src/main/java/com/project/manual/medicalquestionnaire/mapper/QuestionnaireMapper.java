package com.project.manual.medicalquestionnaire.mapper;

import com.project.manual.medicalquestionnaire.controller.data.request.QuestionnaireAnswerRequest;
import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.domain.Answer;
import com.project.manual.medicalquestionnaire.domain.Questionnaire;
import com.project.manual.medicalquestionnaire.domain.QuestionnaireAnswer;
import com.project.manual.medicalquestionnaire.domain.RuleCondition;
import java.util.List;

public abstract class QuestionnaireMapper {
  public static QuestionnaireResponse toResponse(Questionnaire questionnaire) {
    QuestionnaireResponse questionnaireResponse = new QuestionnaireResponse();

    questionnaireResponse.setId(questionnaire.getId());
    questionnaireResponse.setTitle(questionnaire.getTitle());
    questionnaireResponse.setEnabled(questionnaire.isEnabled());
    questionnaireResponse.setQuestions(questionnaire.getQuestions());
    questionnaireResponse.setCreatedAt(questionnaire.getCreatedAt());

    return questionnaireResponse;
  }

  public static List<QuestionnaireResponse> toResponseList(List<Questionnaire> questionnaireList) {
    return questionnaireList.stream().map(QuestionnaireMapper::toResponse).toList();
  }

  public static QuestionnaireAnswer toQuestionnaireAnswer(
      QuestionnaireAnswerRequest questionnaireAnswerRequest) {
    QuestionnaireAnswer questionnaireAnswer = new QuestionnaireAnswer();
    questionnaireAnswer.setQuestionnaireId(questionnaireAnswerRequest.getQuestionnaireId());
    questionnaireAnswer.setUserId(questionnaireAnswerRequest.getUserId());
    questionnaireAnswer.setAnswers(questionnaireAnswerRequest.getAnswers());
    return questionnaireAnswer;
  }

  public static RuleCondition toRuleCondition(Answer answer) {
    RuleCondition ruleCondition = new RuleCondition();
    ruleCondition.setQuestionId(answer.getQuestionId());
    ruleCondition.setChoiceId(answer.getChoiceId());
    ruleCondition.setSubQuestionChoiceId(answer.getSubQuestionChoiceId());
    return ruleCondition;
  }
}
