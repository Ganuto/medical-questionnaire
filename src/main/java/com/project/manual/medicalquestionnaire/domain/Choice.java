package com.project.manual.medicalquestionnaire.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Choice {
  @Field("id") // In the future, should be changed to @MongoId(FieldType.OBJECT_ID)
  private String id;

  private String value;
  private String nextQuestionId;
  private String subQuestionId;
}
