package com.project.manual.medicalquestionnaire.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRecommendationAnswer {
  @NotNull private Long questionId;
  @NotNull private Long choiceId;
  private Long subQuestionChoiceId;
}
