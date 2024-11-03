package com.project.manual.medicalquestionnaire.service;

import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.domain.Questionnaire;
import java.util.List;

public interface QuestionnaireService {
  List<QuestionnaireResponse> findAll();
}
