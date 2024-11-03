package com.project.manual.medicalquestionnaire.domain;

import jakarta.persistence.Id;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
  private String questionId;
  private String text;
  private List<Choice> choices;
}
