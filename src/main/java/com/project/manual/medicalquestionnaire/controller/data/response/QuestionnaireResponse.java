package com.project.manual.medicalquestionnaire.controller.data.response;

import com.project.manual.medicalquestionnaire.domain.Question;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionnaireResponse {
  private String questionnaireId;
  private String title;
  private List<Question> questions;
  private LocalDate createdAt;
}
