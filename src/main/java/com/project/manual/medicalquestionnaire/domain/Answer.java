package com.project.manual.medicalquestionnaire.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
  private Long choiceId;
  private List<Product> excludedProductIds;
  private Long subQuestionChoiceId;
}
