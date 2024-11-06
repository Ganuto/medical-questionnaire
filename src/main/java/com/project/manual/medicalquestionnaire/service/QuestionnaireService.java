package com.project.manual.medicalquestionnaire.service;

import com.project.manual.medicalquestionnaire.controller.data.request.QuestionnaireRecommendationRequest;
import com.project.manual.medicalquestionnaire.controller.data.response.QuestionnaireResponse;
import com.project.manual.medicalquestionnaire.controller.data.response.RecommendationResponse;
import com.project.manual.medicalquestionnaire.domain.Recommendation;

import java.util.List;

public interface QuestionnaireService {
  List<QuestionnaireResponse> findAll();

  QuestionnaireResponse findById(String id);

  RecommendationResponse processRecommendation(QuestionnaireRecommendationRequest questionnaireRecommendationRequest);
}
