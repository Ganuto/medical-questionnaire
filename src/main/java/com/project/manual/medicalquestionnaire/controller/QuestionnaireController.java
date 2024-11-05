package com.project.manual.medicalquestionnaire.controller;

import com.project.manual.medicalquestionnaire.controller.data.request.QuestionnaireAnswerRequest;
import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.service.QuestionnaireService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/questionnaires")
public class QuestionnaireController {

  private final QuestionnaireService questionnaireService;

  @GetMapping
  public ResponseEntity<List<QuestionnaireResponse>> getAll() {
    return ResponseEntity.ok(questionnaireService.findAll());
  }

  @GetMapping("/questionnaire/{id}")
  public ResponseEntity<QuestionnaireResponse> getById(
      @Pattern(regexp = "^[a-f\\d]{24}$") @PathVariable String id) {
    return ResponseEntity.ok(questionnaireService.findById(id));
  }

  @PostMapping("/questionnaire/submit")
  public ResponseEntity<List<String>> getRecommendation(
      @RequestBody @Valid QuestionnaireAnswerRequest questionnaireAnswerRequest) {
    return ResponseEntity.ok(
        questionnaireService.processRecommendation(questionnaireAnswerRequest));
  }
}
