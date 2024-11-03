package com.project.manual.medicalquestionnaire.domain;

import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "questionnaire")
public class Questionnaire {
  @Id private String id;
  private String questionnaireId;
  private String title;
  private List<Question> questions;
  private LocalDate createdAt;
}
