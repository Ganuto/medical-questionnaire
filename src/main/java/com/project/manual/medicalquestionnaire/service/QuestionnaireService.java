package com.project.manual.medicalquestionnaire.service;

import com.project.manual.medicalquestionnaire.controller.data.request.QuestionnaireRecommendationRequest;
import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;

import java.util.List;

public interface QuestionnaireService {
  List<QuestionnaireResponse> findAll();

  QuestionnaireResponse findById(String id);

  List<String> processRecommendation(QuestionnaireRecommendationRequest questionnaireRecommendationRequest);
}
