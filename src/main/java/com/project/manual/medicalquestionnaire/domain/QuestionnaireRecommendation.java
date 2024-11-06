package com.project.manual.medicalquestionnaire.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QuestionnaireRecommendation {
  private String questionnaireId;
  private Long userId;
  private List<Answer> answers;
}
