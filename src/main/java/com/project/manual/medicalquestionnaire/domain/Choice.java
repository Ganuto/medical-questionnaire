package com.project.manual.medicalquestionnaire.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Choice {
  @Field("id")
  private String id;
  private String value;
  private String nextQuestionId;
  private String subQuestionId;
}
