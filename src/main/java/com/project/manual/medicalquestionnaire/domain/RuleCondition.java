package com.project.manual.medicalquestionnaire.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RuleCondition {
  private String questionId;
  private String choiceId;
  private String subQuestionChoiceId;
}
