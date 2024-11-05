package com.project.manual.medicalquestionnaire.service;

import com.project.manual.medicalquestionnaire.controller.data.request.QuestionnaireAnswerRequest;
import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.domain.QuestionnaireAnswer;
import java.util.List;

public interface QuestionnaireService {
  List<QuestionnaireResponse> findAll();

  QuestionnaireResponse findById(String id);

  List<String> processRecommendation(QuestionnaireAnswerRequest questionnaireAnswerRequest);
}
