package com.project.manual.medicalquestionnaire.controller;

import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.service.QuestionnaireService;
import java.util.List;

import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questionnaires")
public class QuestionnaireController {

  private final QuestionnaireService questionnaireService;

  @GetMapping
  public ResponseEntity<List<QuestionnaireResponse>> get() {
    return ResponseEntity.ok(questionnaireService.findAll());
  }

  @GetMapping("/questionnaire")
  public ResponseEntity<QuestionnaireResponse> getById(
      @Pattern(
              regexp = "^[a-f\\d]{24}$",
              message = "Id must follow the regex pattern [^[a-f\\d]{24}$]")
          @RequestParam
          String id) {
    return ResponseEntity.ok(questionnaireService.findById(id));
  }
}
