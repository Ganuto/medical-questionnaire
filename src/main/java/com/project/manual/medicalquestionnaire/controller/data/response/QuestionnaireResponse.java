package com.project.manual.medicalquestionnaire.controller.data.response;

import com.project.manual.medicalquestionnaire.domain.Question;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionnaireResponse {
  private String id;
  private String title;
  private boolean enabled;
  private List<Question> questions;
  private LocalDateTime createdAt;
}
