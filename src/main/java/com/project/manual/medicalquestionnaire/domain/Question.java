package com.project.manual.medicalquestionnaire.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
  private String id;
  private boolean enabled;
  private int order;
  private String text;
  private List<Choice> choices;
}
