package com.project.manual.medicalquestionnaire.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Question {
  @Field("id")
  private String id;
  private boolean enabled;
  private int order;
  private String title;
  private List<Choice> choices;
}
