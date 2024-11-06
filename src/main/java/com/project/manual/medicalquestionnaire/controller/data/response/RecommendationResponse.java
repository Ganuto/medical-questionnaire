package com.project.manual.medicalquestionnaire.controller.data.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecommendationResponse {
  private List<String> recommendedProducts;
}
