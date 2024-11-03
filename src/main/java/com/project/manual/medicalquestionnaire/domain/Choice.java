package com.project.manual.medicalquestionnaire.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Choice {
  private String id;
  private String value;
  private String nextQuestionId;
  private String subQuestionId;
}
