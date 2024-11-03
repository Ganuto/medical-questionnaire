package com.project.manual.medicalquestionnaire.controller;

import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.service.QuestionnaireService;
import java.util.List;
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
}
