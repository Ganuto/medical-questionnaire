package com.project.manual.medicalquestionnaire.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Document(collection = "questionnaire")
public class Questionnaire {
  @MongoId(FieldType.OBJECT_ID)
  private String id;
  private String title;
  private boolean enabled;
  private List<Question> questions;
  private LocalDateTime createdAt;
}
