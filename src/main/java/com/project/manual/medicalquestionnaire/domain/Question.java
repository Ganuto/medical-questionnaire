package com.project.manual.medicalquestionnaire.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Question {
  @Field("id") // In the future, should be changed to @MongoId(FieldType.OBJECT_ID)
  private String id;

  private boolean enabled;
  private Integer order;
  private String title;
  private List<Choice> choices;
  private List<Question> subQuestions;
}
