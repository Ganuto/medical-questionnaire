package com.project.manual.medicalquestionnaire.domain;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Choice {
  private String choiceId;
  private String text;
  private String nextQuestion;
}
