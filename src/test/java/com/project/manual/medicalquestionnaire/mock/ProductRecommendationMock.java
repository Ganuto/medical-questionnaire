package com.project.manual.medicalquestionnaire.mock;

import com.project.manual.medicalquestionnaire.controller.data.response.RecommendationResponse;
import com.project.manual.medicalquestionnaire.domain.ProductRecommendationRule;
import com.project.manual.medicalquestionnaire.domain.Recommendation;
import com.project.manual.medicalquestionnaire.domain.RuleCondition;
import java.util.List;

public abstract class ProductRecommendationMock {
  public static Recommendation createRecommendationMock() {
    Recommendation recommendation = new Recommendation();
    recommendation.setRecommendedProducts(List.of("TADALAFIL_20"));
    return recommendation;
  }

  public static RecommendationResponse createRecommendationResponseMock() {
    RecommendationResponse recommendationResponse = new RecommendationResponse();
    recommendationResponse.setRecommendedProducts(List.of("TADALAFIL_20"));
    return recommendationResponse;
  }

  public static RuleCondition createRuleConditionMock() {
    RuleCondition ruleCondition = new RuleCondition();
    ruleCondition.setQuestionId("1");
    ruleCondition.setChoiceId("1");
    ruleCondition.setSubQuestionChoiceId(null);
    return ruleCondition;
  }

  public static ProductRecommendationRule createProductRecommendationRuleMock() {
    ProductRecommendationRule productRecommendationRule = new ProductRecommendationRule();
    productRecommendationRule.setId("1");
    productRecommendationRule.setRejection(false);
    productRecommendationRule.setQuestionnaireId("8029565399d62832fd94b645");
    productRecommendationRule.setConditions(List.of(createRuleConditionMock()));
    productRecommendationRule.setRecommendedProductIds(List.of("TADALAFIL_20"));
    return productRecommendationRule;
  }
}
