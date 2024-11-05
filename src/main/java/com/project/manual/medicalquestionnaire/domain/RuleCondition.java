package com.project.manual.medicalquestionnaire.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RuleCondition {
  private String questionId;
  private String choiceId;
  private String subQuestionChoiceId;
}
