package com.project.manual.medicalquestionnaire.controller.data.request;

import com.project.manual.medicalquestionnaire.domain.Answer;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionnaireAnswerRequest {
  @NotEmpty
  @Pattern(regexp = "^[a-f\\d]{24}$", message = "Id must follow the regex pattern [^[a-f\\d]{24}$]")
  private String questionnaireId;
  @NotNull private Long userId;
  @NotEmpty private List<Answer> answers;
}
